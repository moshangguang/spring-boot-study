package com.springboot;

import com.alibaba.fastjson.JSON;
import com.springboot.entity.*;
import com.springboot.service.A4Service;
import com.springboot.service.BService;
import com.springboot.service.CService;
import com.springboot.service.DService;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.junit.Before;
import org.springframework.asm.ClassReader;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.type.classreading.AnnotationMetadataReadingVisitor;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

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
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private BService bService;
    @Autowired
    @Qualifier("f1")
    private F f1;
    @Autowired
    @Qualifier("f2")
    private F f2;
    @Autowired
    @Qualifier("f3")
    private F f3;
    @Autowired
    private CService cService;
    @Autowired
    private DService dService;
    @Autowired
    private DefaultListableBeanFactory defaultListableBeanFactory;
    private final static String TOPIC_NAME = "my-replicated-topic";

    @Test
    public void test12() throws ExecutionException, InterruptedException {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.6.86:9092,192.168.6.86:9093,192.168.6.86:9094");
        props.put(ProducerConfig.RETRIES_CONFIG, 3);
        props.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        int msgNum = 5;
        for (int i = 1; i <= msgNum; i++) {
            Student student = new Student(i, "A" + i);
            ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(TOPIC_NAME
                    , Integer.valueOf(student.getId()).toString(), JSON.toJSONString(student));
            RecordMetadata metadata = producer.send(producerRecord).get();
            System.out.println("同步方式发送消息结果：" + "topic-" + metadata.topic() + "|partition-"
                    + metadata.partition() + "|offset-" + metadata.offset());
        }


    }

    @Test
    public void test011() {
        System.out.println("a1Service:" + defaultListableBeanFactory.getBeanDefinition("a1Service").getClass());
        System.out.println("userService:" + defaultListableBeanFactory.getBeanDefinition("userService").getClass());
        System.out.println("g:" + defaultListableBeanFactory.getBeanDefinition(G.class.getName()).getClass());
    }

    @Test
    public void test11() {
        System.out.println(Math.pow(16, 6));
        new HashMap<>().put(1, 1);
        new HashMap<>().remove(1);
        new ConcurrentHashMap<>();
        int a = 1, b = 2, c = 3;
        a = b = c;
        System.out.println(a + " " + b);

    }

    @Test
    public void test10() {
        System.out.println(beanFactory.getBean("a3Service", new A4Service()));
        System.out.println(beanFactory.getBean("a3Service", new A4Service()));

        System.out.println(beanFactory.getBean("a3Service", new A4Service(), new A4Service()));
        try {
            //beanFactory.getBean("a3Service", new A4Service(), new A4Service(), new A4Service());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test09() {
        System.out.println(cService.getDService().getClass());
        System.out.println(dService.getCService().getClass());
        System.out.println("=========");
        cService.getDService().sayHello();
        dService.getCService().sayHello();
    }

    @Test
    public void test08() {
        System.out.println(cService.getClass());
        cService.sayHello();
    }

    @Test
    public void test07() {
        System.out.println("f1====>" + f1);
        System.out.println("f2====>" + f2);
        System.out.println("f3====>" + f3);
    }

    @Test
    public void test06() {
        System.out.println(bService.getT());
        System.out.println(bService.getS());
    }

    @Test
    public void test05() {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.registerShutdownHook();
        configApplicationContext.close();
    }

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
