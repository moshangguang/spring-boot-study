package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.beans.ConstructorProperties;

public abstract class AbstractBService<T, S> {
    @Autowired
    private T t;
    @Autowired
    private S s;

    public T getT() {
        return t;
    }

    public S getS() {
        return s;
    }
}
