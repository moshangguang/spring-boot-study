package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class A3Service {
    @Autowired
    private A4Service a4Service;

    @Autowired
    public A3Service(A4Service a4Service) {
        System.out.println("调用A3Service(A4Service a4Service)...");
    }

    public A3Service(A4Service a4Service1, A4Service a4Service2) {
        System.out.println("调用A3Service(A4Service a4Service1, A4Service a4Service2)...");
    }
}
