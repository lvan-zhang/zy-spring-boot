package com.zhangyu.controller;

import com.zhangyu.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/mycache")
    public String getCache () {
        String cacheValue = redisService.getCachedValue("redis_name");
        return cacheValue;
    }
}
