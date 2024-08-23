package com.zhangyu.controller;

import com.zhangyu.service.GetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

    @Autowired
    private GetService getService;

    @GetMapping("name")
    public String getName() {
        String name = getService.getName();
        return name;
    }
}
