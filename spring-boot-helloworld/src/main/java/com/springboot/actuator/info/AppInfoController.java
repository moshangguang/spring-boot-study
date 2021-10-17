package com.springboot.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AppInfoController implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> map = new HashMap<>();
        map.put("java", "spring");
        map.put("python", "flask");
        builder.withDetail("hello", "world").
                withDetail("age", 10).withDetails(map);
    }
}
