package com.example.junittest.controller;

import com.example.junittest.service.TestService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/8/21 17:43
 **/
@RestController
@RequestMapping("test")
@Slf4j
public class TestController {
    @Resource
    private TestService testService;

    @RequestMapping(value = "test1", method = RequestMethod.GET)
    public String getTestInfo() {
        log.debug("测试运行成功");
        return testService.testMethod();
    }

    @RequestMapping(value = "mongo", method = RequestMethod.GET)
    public String getMongoInfo() {
        log.debug("mongo运行成功");
        return testService.mongoTest();
    }
    @RequestMapping(value = "mongoInsert", method = RequestMethod.GET)
    public boolean mongoInsert() {
        log.debug("mongo运行成功");
        return testService.insertMongo();
    }
}