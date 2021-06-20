package com.galaxy.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author lane
 * @date 2021年06月17日 上午11:02
 */
public class ProviderDemo2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider2.xml");

        context.start();
        //先不要关掉，阻塞下
        System.in.read();

//        Thread.sleep(100000);


    }
}
