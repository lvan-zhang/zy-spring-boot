package com.zhangyu.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerTask {
    @Scheduled(cron = "*/6 * * * * ?")
    private void process () {
        System.out.println("这是一个定时任务");
    }
}
