package com.zhangyu.controller;

import com.zhangyu.config.ApiResponse;
import com.zhangyu.model.UserForJpa;
import com.zhangyu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloWorldController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index() {
        return "Hello Spring Boot 3.x!";
    }

    @RequestMapping("/hello")
    public ApiResponse hello() {
        List<UserForJpa> userList = userRepository.findAll();
        Map resultMap = new HashMap();
        resultMap.put("data", userList);
        return ApiResponse.success(userList);
    }
}
