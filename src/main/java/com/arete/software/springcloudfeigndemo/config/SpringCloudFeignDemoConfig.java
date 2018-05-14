package com.arete.software.springcloudfeigndemo.config;

import feign.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.arete.software.springcloudfeigndemo")
@EnableAutoConfiguration
@Configuration
public class SpringCloudFeignDemoConfig {

    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.BASIC;
    }
}
