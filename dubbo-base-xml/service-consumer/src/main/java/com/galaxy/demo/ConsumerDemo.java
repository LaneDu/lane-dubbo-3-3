package com.galaxy.demo;

import com.galaxy.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author lane
 * @date 2021年06月17日 上午11:10
 */
public class ConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        applicationContext.start();//不加也可以
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");

        String galaxy = helloService.syaHello("galaxy");
        //zk和提供者必须先启动
        System.out.println(galaxy);
        TimeUnit.SECONDS.sleep(600);
    }

}
