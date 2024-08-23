package com.zhangyu.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "custom-health")
public class CustomHealthEndpoint {
    @Bean
    @ReadOperation
    public Map<String, Object> customHealth() {
        return Map.of("status", 200, "details", "测试");
    }
}
