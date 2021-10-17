package com.springboot.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MyHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //builder.up();
        //builder.down();
        //但凡不是up都是不健康
        //builder.status(Status.UP);
        builder.status(Status.UP);
        Map<String, Object> map = new HashMap<>();
        map.put("hello", "world");
        map.put("age", 20);
        builder.withDetail("name", "tom");
        builder.withDetails(map);
    }
}
