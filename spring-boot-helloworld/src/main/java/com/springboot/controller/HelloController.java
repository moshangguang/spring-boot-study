package com.springboot.controller;

import com.springboot.entity.Worker;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    @PostMapping("/worker")
    public Worker helloWorker(@RequestBody Worker worker) {
        return worker;
    }
}
