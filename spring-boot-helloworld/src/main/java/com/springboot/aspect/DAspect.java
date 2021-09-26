package com.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DAspect {
    @Pointcut("execution(* com.springboot.service.DService.*(..))")
    public void serviceLog() {

    }

    @Before("serviceLog()")
    public void logBeforeService(JoinPoint joinPoint) {
        System.out.println("invoke DService method:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
