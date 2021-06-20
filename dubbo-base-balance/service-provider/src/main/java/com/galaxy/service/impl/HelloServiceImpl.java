package com.galaxy.service.impl;

import com.galaxy.service.HelloService;

import java.security.SignatureException;
import java.util.concurrent.TimeUnit;

/**
 * @author lane
 * @date 2021年06月17日 上午10:33
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {

        return "hello3:"+name;
    }
}
