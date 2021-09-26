package com.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CAspect {
    @Pointcut("execution(* com.springboot.service.CService.*(..))")
    public void serviceLog() {

    }

    @Before("serviceLog()")
    public void logBeforeService(JoinPoint joinPoint) {
        System.out.println("invoke CService method:" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}