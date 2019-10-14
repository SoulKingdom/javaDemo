package com.example.junittest.controller;

import com.example.junittest.design.mode.prototype.Person;
import com.example.junittest.service.RedisService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/3 11:23
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private RedisService redisService;

    @PostMapping("/getKey")
    public String getKey() {
        return redisService.getValue();
    }

    @PostMapping("/setKey")
    public String setValue() {
        return redisService.setValue("aaaa");
    }

    @PostMapping("/getPerson")
    public Person getPerson() {
        return redisService.getPerson();
    }

    @PostMapping("/setPerson")
    public Integer setPerson() {
        return redisService.setPerson();
    }
}