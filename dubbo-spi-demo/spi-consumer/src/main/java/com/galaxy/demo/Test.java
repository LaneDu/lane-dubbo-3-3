package com.galaxy.demo;

import com.galaxy.service.HelloService;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.Iterator;
import java.util.Set;

/**
 * @author lane
 * @date 2021年06月17日 下午4:42
 */
public class Test {
    public static void main(String[] args) {
        //key可以默认，可以指定dubbo自己转码HelloService ==>hello.service
        URL url = URL.valueOf("http://127.0.0.1:1027?hello.service=cat");

        testAdaptive(url);

    }

    public static void testAdaptive(URL url) {
        ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);
        HelloService adaptiveExtension = extensionLoader.getAdaptiveExtension();
        //根据URL参数key选择不同的实现类来访问
        String s = adaptiveExtension.sayHello(url);
        System.out.println(s);
    }

    public static void test1() {
        //获取扩展加载器
        ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);
        //遍历所有的扩展点 meta-info/dubbo
        Set<String> supportedExtensions = extensionLoader.getSupportedExtensions();
        for (String extension : supportedExtensions) {
            HelloService extension1 = extensionLoader.getExtension(extension);
            System.out.println(extension1.sayHello());
        }
    }
}