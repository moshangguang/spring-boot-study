package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CService {
    @Autowired
    private DService dService;

    public DService getDService() {
        return dService;
    }

    public void sayHello() {
        System.out.println("cService say:hello!!!");
    }
}
