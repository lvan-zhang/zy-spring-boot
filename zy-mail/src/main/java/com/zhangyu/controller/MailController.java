package com.zhangyu.controller;

import com.zhangyu.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    @Autowired
    private MailService mailService;

    @GetMapping("sendMail")
    public String toSendMail() {
        mailService.sendSimpleMail("18716016579@163.com", "test simple mail1"," hello this is simple mail");
        return "发送完成";
    }

}
