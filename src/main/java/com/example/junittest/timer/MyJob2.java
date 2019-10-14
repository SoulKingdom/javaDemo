package com.example.junittest.timer;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/16 15:10
 **/
@Slf4j
public class MyJob2 extends QuartzJobBean {
    private  int num ;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        num++;
        log.info("定时器正在执行："+num);
    }
}