package com.springboot;

import com.springboot.entity.Cat;
import com.springboot.entity.Dog;
import com.springboot.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private Teacher teacher;
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;


    @Test
    public void test01() {
        System.out.println("teacher:" + teacher);
        System.out.println("cat:" + cat);
        System.out.println("dog:" + dog);
        ServerProperties.Undertow undertow = new ServerProperties.Undertow();
        System.out.println(undertow.getMaxHeaders());
    }

}
