package com.zhangyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开启定时任务
//@EnableScheduling
//Mybatis扫描
@MapperScan("com.zhangyu.mapper")
public class ZySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZySpringBootApplication.class, args);
	}

}
