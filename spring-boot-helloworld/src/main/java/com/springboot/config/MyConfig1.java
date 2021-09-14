package com.springboot.config;

import com.springboot.entity.Dog;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(Dog.class)
public class MyConfig1 {
}
