package com.springboot;

import com.springboot.entity.Dog;
import com.springboot.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private Dog dog;
    @Autowired
    private Teacher teacher;

    @Test
    public void test01() {
        System.out.println("dog:" + dog);
        System.out.println("teacher:" + teacher);
    }

}
