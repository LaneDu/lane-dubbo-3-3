package com.galaxy.demo;

import com.galaxy.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author lane
 * @date 2021年06月17日 上午11:10
 */
public class ConsumerDemo {

    public static void main(String[] args) throws InterruptedException, IOException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:dubbo-consumer.xml");
        applicationContext.start();//不加也可以
        HelloService helloService = (HelloService) applicationContext.getBean("helloService");

        while(true){
            Thread.sleep(10);
            new Thread(()->{

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String galaxy = helloService.syaHello("galaxy");
                System.out.println(galaxy);

            }).start();




        }


    }

}
