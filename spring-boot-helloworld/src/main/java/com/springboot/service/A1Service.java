package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A1Service {
    @Autowired
    private A2Service a2Service;
}
