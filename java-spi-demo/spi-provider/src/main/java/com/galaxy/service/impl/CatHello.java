package com.galaxy.service.impl;

import com.galaxy.service.HelloService;

/**
 * @author lane
 * @date 2021年06月17日 下午3:56
 */
public class CatHello implements HelloService {


    public String sayHello(String name) {

        return "hi cat";
    }
}
