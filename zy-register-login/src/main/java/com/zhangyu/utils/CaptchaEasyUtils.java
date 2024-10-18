package com.zhangyu.utils;

import com.wf.captcha.SpecCaptcha;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * CaptchaEasyUtils 工具类，用于生成各种类型的验证码。
 */
@Component
public class CaptchaEasyUtils {

    /**
     * 生成并输出图片验证码（PNG 格式）。
     *
     * @return 返回验证码的字符串内容
     */
    public Map createLineCaptcha() throws IOException {
        // 创建文字验证码
        SpecCaptcha captcha = new SpecCaptcha(200, 100, 4);

        // 获取验证码的内容
        String captchaText = captcha.text();

        // 创建 ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // 输出验证码图片到字节数组输出流
        captcha.out(byteArrayOutputStream);

        // 将图片转化为 Base64 编码
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        String base = Base64.getEncoder().encodeToString(imageBytes);

        // 释放资源
        byteArrayOutputStream.close();

        // 获取uuid
        String uuid = UUID.randomUUID().toString(true);
        Map resultMap = new HashMap();
        resultMap.put("text", captchaText);
        resultMap.put("img", "data:image/png;base64," + base);
        resultMap.put("uuid", uuid);

        return resultMap;
    }

}
