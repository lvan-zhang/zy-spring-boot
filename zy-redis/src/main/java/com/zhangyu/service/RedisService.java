package com.zhangyu.service;

import com.zhangyu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisUtil redisUtil;

    public String getCachedValue(String key) {
        // 先从缓存中获取数据
        Object cachedValue = redisUtil.get(key);
        Boolean hasKey = redisUtil.exists(key);

        // 如果缓存中不存在，则模拟从数据库或其他数据源中获取数据，并存入缓存
        if (!hasKey) {
            System.out.println("正在从数据库取数据并存储进redis");
            // 模拟从数据源获取数据
            String dataFromDataSource = "mysql data";
            // 存入缓存
            redisUtil.set(key, dataFromDataSource);
            return dataFromDataSource;
        } else {
            System.out.println("这是获取到redis中的数据: " + cachedValue);
            return cachedValue.toString();
        }
    }
}
