package com.springboot;

import com.springboot.entity.*;
import org.springframework.asm.ClassReader;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private Teacher teacher;
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    @Autowired
    private Boss boss;

    @Test
    public void test04() {
        System.out.println(boss);
    }

    @Test
    public void test03() {
        Student student = new Student();
        System.out.println(student);
        Student student1 = new Student(2, "阿珍", 26);
        System.out.println(student1);
        Student student2 = new Student(1, "阿强");
        student2.setAge(30);
        System.out.println(student2);
        Student student3 = new Student(2, "阿珍", 26);
        System.out.println(student1.equals(student3));
    }

    @Test
    public void test02() {
        try {
            ClassReader cr = new ClassReader("com.thirdparty.config.MyConfig2");
            AnnotationMetadataReadingVisitor visitor = new AnnotationMetadataReadingVisitor(getClass().getClassLoader());
            cr.accept(visitor, ClassReader.SKIP_DEBUG);
            Map<String, Object> annotationAttributes = visitor.getAnnotationAttributes("org.springframework.boot.autoconfigure.condition.ConditionalOnClass");
            System.out.println(annotationAttributes.get("value"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test01() {
        System.out.println("teacher:" + teacher);
        System.out.println("cat:" + cat);
        System.out.println("dog:" + dog);
        ServerProperties.Undertow undertow = new ServerProperties.Undertow();
        System.out.println(undertow.getMaxHeaders());
    }

}
