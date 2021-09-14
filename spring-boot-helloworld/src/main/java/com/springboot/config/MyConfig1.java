package com.springboot.config;

import com.springboot.entity.Cat;
import com.springboot.entity.Dog;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(Dog.class)
public class MyConfig1 {
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
