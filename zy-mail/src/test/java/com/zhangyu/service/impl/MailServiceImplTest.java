package com.zhangyu.service.impl;

import com.zhangyu.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    void sendSimpleMail() {
        mailService.sendSimpleMail("18716016579@163.com", "test simple mail"," hello this is simple mail");
    }

    @Test
    void sendHtmlMail() {
    }

    @Test
    void sendAttachmentsMail() {
    }

    @Test
    void sendInlineResourceMail() {
    }
}