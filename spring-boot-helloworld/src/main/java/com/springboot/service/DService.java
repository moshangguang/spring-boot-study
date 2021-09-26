package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DService {
    @Autowired
    private CService cService;

    public CService getCService() {
        return cService;
    }

    public void sayHello() {
        System.out.println("dService say:hello!!!");
    }
}
