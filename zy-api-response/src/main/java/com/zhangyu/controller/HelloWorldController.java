package com.zhangyu.controller;

import com.zhangyu.config.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot 3.x!";
    }

    @RequestMapping("/hello")
    public ApiResponse hello() {
        Map resultMap = new HashMap();
        resultMap.put("text", "hello");
        return ApiResponse.success(resultMap);
    }
}
