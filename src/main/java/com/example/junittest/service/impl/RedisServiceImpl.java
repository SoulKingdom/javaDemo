package com.example.junittest.service.impl;

import com.example.junittest.design.mode.prototype.Person;
import com.example.junittest.service.RedisService;
import com.example.junittest.util.RedisUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *  @dept 上海软件研发中心
 *  @description Redis 值
 *  @author HaoXin.Liu
 *  @date 2019/9/3 13:14
 **/
@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private RedisUtil redisUtil;

    @Override
    public String getValue() {
        Object obj = redisUtil.get("zhangsan");
        String str = String.valueOf(obj);
        return str;
    }

    @Override
    public String setValue(Object obj) {
        boolean flag = redisUtil.set("zhangsan",obj);
        return "success";
    }

    @Override
    public Integer setPerson() {
        Person person  = new Person();
        person.setName("zhangsan");
        List<String> list = new ArrayList<>(2);
        list.add("111");
        list.add("222");
        person.setList(list);
        redisUtil.set("name",person);
        return 1;
    }

    @Override
    public Person getPerson() {
        Person person = (Person) redisUtil.get("name");
        return person;
    }
}