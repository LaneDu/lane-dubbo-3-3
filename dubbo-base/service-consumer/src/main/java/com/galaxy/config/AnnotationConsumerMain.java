package com.galaxy.config;

import com.galaxy.bean.ConsumerComponent;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

/**
 * @author lane
 * @date 2021年06月16日 下午7:08
 */

public class AnnotationConsumerMain {
    public static void main(String[] args) throws IOException {

        AnnotationConfigApplicationContext context  =new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
                context.start();
        ConsumerComponent consumerComponent = context.getBean(ConsumerComponent.class);
        while (true){
            System.in.read();
            String world = consumerComponent.hello("world");
            System.out.println(world);


        }

    }


    @Configuration
    @PropertySource("classpath:/dubbo-consumer.properties")
    @ComponentScan(basePackages = "com.galaxy.bean")
    @EnableDubbo
    static class ConsumerConfiguration{


    }
}
