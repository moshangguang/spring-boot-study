package com.thirdparty.config;

import com.springboot.entity.A;
import com.springboot.entity.B;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@ConditionalOnClass({A.class, B.class})
public class MyConfig2 {
    static {
        System.out.println("打印MyConfig2静态块");
    }
}
