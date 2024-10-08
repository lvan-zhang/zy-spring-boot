package com.zhangyu.utils;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CaptchaHutoolUtils {
    public Map createLineCaptcha () throws IOException {
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100, 4, 4);
        // 获取验证码图片上的文字
        String captchaText = lineCaptcha.getCode();
        // 输出图片
        BufferedImage image = lineCaptcha.getImage();
        // 图片转base64
        String base = ImageToBase64.convertImageToBase64(image);
        // 获取uuid
        String uuid = UUID.randomUUID().toString(true);
        Map resultMap = new HashMap();
        resultMap.put("text", captchaText);
        resultMap.put("img", "data:image/png;base64," + base);
        resultMap.put("uuid", uuid);
        return resultMap;
    }
}
