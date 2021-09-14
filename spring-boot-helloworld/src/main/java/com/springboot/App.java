package com.springboot;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.springboot", "com.thirdparty"})
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        for (String beanDefinitionName : beanFactory.getBeanDefinitionNames()) {
            Object bean = beanFactory.getBean(beanDefinitionName);
            if (bean instanceof CharacterEncodingFilter) {
                CharacterEncodingFilter filter = (CharacterEncodingFilter) bean;
                System.out.println("CharacterEncodingFilter:" + beanDefinitionName + " encoding:" + filter.getEncoding());
            }
            if (bean instanceof DispatcherServlet) {
                System.out.println("DispatcherServlet:" + beanDefinitionName);
            }
            if (bean instanceof InternalResourceViewResolver) {
                System.out.println("InternalResourceViewResolver:" + beanDefinitionName);
            }
            if (bean instanceof MultipartResolver) {
                System.out.println("MultipartResolver:" + beanDefinitionName);
            }
        }
    }
}
