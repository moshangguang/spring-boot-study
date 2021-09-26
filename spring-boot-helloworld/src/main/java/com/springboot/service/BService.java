package com.springboot.service;

import com.springboot.entity.D;
import com.springboot.entity.E;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

@Component
public class BService extends AbstractBService<D, E> {
    public static void main(String[] args) {
        System.out.println(BService.class.getGenericSuperclass().getTypeName());
        for (TypeVariable<? extends Class<?>> typeParameter : BService.class.getSuperclass().getTypeParameters()) {
            System.out.println(typeParameter.getName());
        }
        for (Field declaredField : BService.class.getSuperclass().getDeclaredFields()) {
            System.out.println(declaredField.getGenericType() + " " + declaredField.getName());
        }
    }
}
