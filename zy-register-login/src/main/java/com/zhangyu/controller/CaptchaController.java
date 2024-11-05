package com.zhangyu.controller;

import com.zhangyu.constant.CacheConstants;
import com.zhangyu.utils.CaptchaEasyUtils;
import com.zhangyu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class CaptchaController {

    @Autowired
    private CaptchaEasyUtils captchaEasyUtils;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/captchaImage")
    public Map getCaptcha () throws IOException {
        Map captchaInfo = captchaEasyUtils.createLineCaptcha();
        redisUtil.set(CacheConstants.CAPTCHA_CODE_KEY + captchaInfo.get("uuid"), (String) captchaInfo.get("text"));
        return captchaInfo;
    }
}
