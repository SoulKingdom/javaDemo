package com.example.junittest.service.impl;

import com.example.junittest.service.MqService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/11 13:28
 **/
@Service
public class MqServiceImpl implements MqService {

    @Resource
    private AmqpTemplate rabbitTemplate;

    @Override
    public void send(int num) {
        String context = "hello" + num + ":" + new Date();
        String[] contexts = new String[10];
/*        for (int i = 0; i < contexts.length;i++) {
            contexts[i] = context + i;
        }*/
        System.out.println("Sender:" + context);
        rabbitTemplate.convertAndSend("hello", context);
    }
}