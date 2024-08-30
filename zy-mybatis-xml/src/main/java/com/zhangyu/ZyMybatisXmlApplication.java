package com.zhangyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhangyu.mapper")
public class ZyMybatisXmlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZyMybatisXmlApplication.class, args);
    }

}
