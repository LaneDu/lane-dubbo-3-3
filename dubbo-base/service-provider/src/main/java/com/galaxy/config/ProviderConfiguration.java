package com.galaxy.config;

import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author lane
 * @date 2021年06月16日 下午6:30
 */
@Configuration
@EnableDubbo(scanBasePackages = "com.galaxy.service.impl")
@PropertySource("classpath:/dubbo-provider.properties")
public class ProviderConfiguration {

    @Bean
    RegistryConfig registryConfig (){

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        return registryConfig;
    }
}
