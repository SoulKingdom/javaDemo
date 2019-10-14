package com.example.junittest.entity;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/16 14:56
 **/
@Component
public class ScheduledTask {
    private static int num=0;
    @Scheduled(fixedRate = 1000*3)
    public void fixedRate(){
        num++;
        System.out.println("定时器执行次数:"+num);
    }
}