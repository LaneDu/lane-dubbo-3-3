package com.galaxy.bean;

import com.galaxy.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

/**
 * @author lane
 * @date 2021年06月16日 下午7:00
 */
@Component
public class ConsumerComponent {
    @Reference
    private HelloService helloService;

    public String hello(String name){
        String hello = helloService.sayHello(name);

        return hello;
    }
}
