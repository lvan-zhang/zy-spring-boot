package com.zhangyu.endpoint;

import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Builder builder) throws Exception {
        // 在此处添加自定义健康检查逻辑
        builder.up().withDetail("custom", "Custom health check passed");
    }
}
