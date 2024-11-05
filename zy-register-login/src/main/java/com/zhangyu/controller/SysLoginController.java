package com.zhangyu.controller;

import com.zhangyu.domain.model.LoginBody;
import com.zhangyu.service.SysLoginService;
import com.zhangyu.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService sysLoginService;

    @GetMapping("/hello")
    public String getName() {
        return "hello";
    }

    @PostMapping("/custom-login")
    public String login(@RequestBody LoginBody user) {
        String msg = sysLoginService.login(user);
        return StringUtils.isEmpty(msg) ? "成功" : msg;
    }
}
