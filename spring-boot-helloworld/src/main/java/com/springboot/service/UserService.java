package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public class UserService {
    @Autowired
    private OrderService orderService;
    @Resource
    private AddressService addressService;

    public void init() {
        System.out.println("userService init...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("userService postConstruct...");
    }

}
