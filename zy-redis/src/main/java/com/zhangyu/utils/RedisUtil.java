package com.zhangyu.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    // 默认过期时间，单位秒
    private static final long DEFAULT_EXPIRATION = 3600;

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value, DEFAULT_EXPIRATION, TimeUnit.SECONDS);
    }

    public void set(String key, String value, long expirationInSeconds) {
        redisTemplate.opsForValue().set(key, value, expirationInSeconds, TimeUnit.SECONDS);
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }
}