package com.galaxy.service.impl;

import com.galaxy.service.HelloService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author lane
 * @date 2021年06月16日 下午6:22
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello123"+name;
    }
}
