package com.zhangyu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${info.app.name}")
    private String appName;

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

    @RequestMapping("/hello")
    public String index() {
        logger.info("你好啊，我是log4j");
        return this.appName;
    }
}