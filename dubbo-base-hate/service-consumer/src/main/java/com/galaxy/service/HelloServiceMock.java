package com.galaxy.service;

import com.galaxy.service.HelloService;

/**
 * @author lane
 * @date 2021年06月17日 下午3:29
 */
public class HelloServiceMock implements HelloService {
    @Override
    public String syaHello(String name) {


        return "本地的默认：hello mock，提供者调用失败";
    }
}
