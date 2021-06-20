package com.galaxy;

import com.galaxy.service.HelloService;
import com.galaxy.service.impl.HumanHello;

import java.util.ServiceLoader;

/**
 * @author lane
 * @date 2021年06月17日 下午4:00
 */
public class demo {

    public static void main(String[] args) {
        //java 传统方式实现
        HelloService helloService = new HumanHello();
        helloService.sayHello(null);
        //Java spi 实现 解耦轻量
       final ServiceLoader<HelloService>  helloServiceSpi = ServiceLoader.load(HelloService.class);

        for (HelloService helloservice: helloServiceSpi) {
            String s = helloservice.sayHello(null);
            System.out.println(s);
        }

    }
}
