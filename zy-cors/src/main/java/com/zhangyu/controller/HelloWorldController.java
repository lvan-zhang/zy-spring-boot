package com.zhangyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot 3.x!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
