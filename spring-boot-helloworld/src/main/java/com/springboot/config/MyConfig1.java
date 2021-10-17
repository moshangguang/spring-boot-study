package com.springboot.config;

import com.springboot.entity.*;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(Dog.class)
@Import(G.class)
public class MyConfig1 {
    @Bean
    public Cat cat() {
        return new Cat();
    }

    @Bean(initMethod = "init")
    public UserService userService() {
        return new UserService();
    }

    @Bean(autowire = Autowire.BY_NAME)
    public C getC() {
        return new C();
    }

    @Bean
    @Qualifier("f1")
    public F getF1() {
        F f = new F();
        System.out.println("f1:" + f);
        return f;
    }

    @Bean
    @Qualifier("f2")
    public F getF2() {
        F f = new F();
        System.out.println("f2:" + f);
        return f;
    }
}
