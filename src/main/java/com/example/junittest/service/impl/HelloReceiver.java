package com.example.junittest.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/11 13:40
 **/
@Component
@RabbitListener(queues = {"hello"})
public class HelloReceiver {
    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver1:"+hello);
    }
}