package com.zhangyu.controller;

import com.zhangyu.utils.CaptchaHutoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
public class CaptchaController {

    @Autowired
    private CaptchaHutoolUtils captchaHutoolUtils;

    @GetMapping("/captcha")
    public Map getCaptcha () throws IOException {
        Map captchaInfo = captchaHutoolUtils.createLineCaptcha();
        return captchaInfo;
    }
}
