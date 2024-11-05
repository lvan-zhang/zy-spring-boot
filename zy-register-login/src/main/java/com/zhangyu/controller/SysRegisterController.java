package com.zhangyu.controller;

import com.zhangyu.domain.model.RegisterBody;
import com.zhangyu.service.SysRegisterService;
import com.zhangyu.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysRegisterController {

    @Autowired
    private SysRegisterService sysRegisterService;

    @PostMapping("/register")
    public String register (@RequestBody RegisterBody user) {
        String msg = sysRegisterService.register(user);
        return StringUtils.isEmpty(msg) ? "成功" : msg;
    }
}
