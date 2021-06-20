package com.galaxy.route;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.registry.Registry;
import org.apache.dubbo.registry.RegistryFactory;

/**
 * @author lane
 * @date 2021年06月18日 下午5:02
 */
public class DubboRouterMain {
    public static void main(String[] args) {
        RegistryFactory
                registryFactory = ExtensionLoader.getExtensionLoader(RegistryFactory.class).getAdaptiveExtension();
        Registry registry = registryFactory.getRegistry(URL.valueOf("zookeeper://127.0.0.1:2181"));
        //配置排除ip为92.168.20.1的机器
        registry.register(URL.valueOf("condition://0.0.0.0/com.galaxy.service.HelloService?category=routers&force=true&dynamic=true&rule="
                + URL.encode("=> host != 192.168.20.1")));
    }

}
