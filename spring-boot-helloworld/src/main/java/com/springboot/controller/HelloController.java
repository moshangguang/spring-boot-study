package com.springboot.controller;

import com.springboot.entity.Worker;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    Counter helloCounter;

    public HelloController(MeterRegistry meterRegistry) {
        helloCounter = meterRegistry.counter("HelloController.hello.count");
    }

    @RequestMapping("/hello")
    public String hello() {
        helloCounter.increment();
        return "hello spring boot";
    }

    @PostMapping("/worker")
    public Worker helloWorker(@RequestBody Worker worker) {
        return worker;
    }
}
