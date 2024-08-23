package com.zhangyu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.profiles.active}")
    private String env;

    @RequestMapping("env")
    public String getEnv () {
        System.out.println("当前环境" + env);
        return this.appName;
    }
}
