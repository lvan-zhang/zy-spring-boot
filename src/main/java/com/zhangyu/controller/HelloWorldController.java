package com.zhangyu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
//    TODO:
    @Value("${info.app.name}")
    private String appName;

    @RequestMapping("/hello")
    public String index(){
        return this.appName;
    }
}
