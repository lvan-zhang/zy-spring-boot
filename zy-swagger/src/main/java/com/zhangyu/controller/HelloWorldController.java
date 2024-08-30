package com.zhangyu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "用户模块", description = "用户模块的描述")
public class HelloWorldController {
    @GetMapping("/spring")
    @Operation(summary = "获取项目框架信息", description = "获取项目框架信息描述")
    public String index() {
        return "Hello Spring Boot 3.x!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
