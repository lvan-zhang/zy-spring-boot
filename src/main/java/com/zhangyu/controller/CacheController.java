package com.zhangyu.controller;

import com.zhangyu.service.MyCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
    @Autowired
    private MyCacheService myCacheService;

    @RequestMapping("/cache")
    public String getCache () {
        return myCacheService.getCachedValue("redis_name");
    }

}
