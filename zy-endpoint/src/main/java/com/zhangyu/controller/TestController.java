package com.zhangyu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("endpoint")
    public void getEndpoint() {

    }
}
