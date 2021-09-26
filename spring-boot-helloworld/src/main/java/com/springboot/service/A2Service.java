package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A2Service {
    @Autowired
    private A1Service a1Service;
}
