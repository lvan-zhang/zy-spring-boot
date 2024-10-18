package com.zhangyu.controller;

import com.zhangyu.utils.CaptchaEasyUtils;
import com.zhangyu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class CaptchaController {

    private String captchaRedisName = "zySpringBoot-";

    @Autowired
    private CaptchaEasyUtils captchaEasyUtils;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/captchaImage")
    public Map getCaptcha () throws IOException {
        Map captchaInfo = captchaEasyUtils.createLineCaptcha();
        redisUtil.set(captchaRedisName + captchaInfo.get("uuid"), (String) captchaInfo.get("text"));
        return captchaInfo;
    }
}
