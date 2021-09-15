package com.springboot;

import com.springboot.entity.Cat;
import com.springboot.entity.Dog;
import com.springboot.entity.Teacher;
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
