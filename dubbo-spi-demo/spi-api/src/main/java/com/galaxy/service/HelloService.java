package com.galaxy.service;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author lane
 * @date 2021年06月17日 下午4:37
 */
@SPI("human")
public interface HelloService {
    String sayHello();
    @Adaptive
    String sayHello(URL url);
}
