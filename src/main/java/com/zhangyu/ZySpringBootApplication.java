package com.zhangyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//开启定时任务
//@EnableScheduling
public class ZySpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZySpringBootApplication.class, args);
	}

}
