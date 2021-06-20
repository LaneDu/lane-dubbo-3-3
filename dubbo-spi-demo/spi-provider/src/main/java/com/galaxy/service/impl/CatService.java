package com.galaxy.service.impl;

import com.galaxy.service.HelloService;
import org.apache.dubbo.common.URL;

/**
 * @author lane
 * @date 2021年06月17日 下午4:38
 */
public class CatService implements HelloService {
    public String sayHello() {
        return "hi cat dubbo";
    }

    @Override
    public String sayHello(URL url) {
        return "hello cat urlAdaptive";
    }
}
