package com.springboot.entity;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

@Component
@Qualifier("f3")
public class F {
    public F() {
        System.out.println("F init..." + this);
    }
}
