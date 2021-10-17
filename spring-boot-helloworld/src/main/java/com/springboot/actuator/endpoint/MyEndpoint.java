package com.springboot.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Component
@Endpoint(id = "myEndpoint")
public class MyEndpoint {
    //这里不允许传参
    @ReadOperation
    public Map getInfo() {
        return Collections.singletonMap("hello", "world");
    }

    @WriteOperation
    public void stop() {
        System.out.println("stop...");
    }
}
