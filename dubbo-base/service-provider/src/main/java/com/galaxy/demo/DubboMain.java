package com.galaxy.demo;

import com.galaxy.config.ProviderConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @author lane
 * @date 2021年06月16日 下午6:35
 */
public class DubboMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);


        context.start();
        System.in.read();


    }
}
