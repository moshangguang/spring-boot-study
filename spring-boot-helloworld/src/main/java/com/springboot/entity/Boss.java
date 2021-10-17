package com.springboot.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties(prefix = "boss")
public class Boss {
    private String name;
    private int age;
    private Date birth;
    private List<String> favorite;
    String[] friends;
    private List<Cat> cats;
    private List<Dog> dogs;
    private Map<String, List<Worker>> workers;

}
