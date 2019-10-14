package com.example.junittest.controller;

import com.example.junittest.service.MqService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/11 13:43
 **/
@Api(tags = {"RabbitMq接口"})
@RestController
@RequestMapping("mq")
public class Mqcontroller {
    @Resource
    private MqService mqService;

    @PostMapping("/helloSend")
    public String helloSend() {
        for (int i = 0;i<10 ;i++){
            mqService.send(i);
        }
        return "发送成功";
    }

}