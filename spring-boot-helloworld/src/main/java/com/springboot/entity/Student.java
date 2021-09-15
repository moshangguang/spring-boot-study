package com.springboot.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/*
使用lombok依赖同时也要安装lombok插件
https://github.com/mplushnikov/lombok-intellij-plugin/releases
 */
//@Data注解在编译时自动生成getter、setter方法
@Data
//自动生成toString()方法
@ToString
//自动生成所有参数的构造方法
@AllArgsConstructor
//自动生成无参构造犯法
@NoArgsConstructor
@EqualsAndHashCode
//使用lombok还可以加上@Slf4j注解，会自动注入log
@Slf4j
public class Student {
    private int id;
    private String name;
    private int age;

    /*
    如果需要根据部分参数生成构造函数，只能自定义
     */
    public Student(int id, String name) {
        log.info("调用Student(int id, String name)方法...");
        this.id = id;
        this.name = name;
    }
}
