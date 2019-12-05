package com.example.junittest.service.impl;

import com.example.junittest.entity.User;
import com.example.junittest.service.TestService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/8/21 17:56
 **/
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public String testMethod() {
        Map<String, List<String>> map = new HashMap<>(0);
        List<String> list = new ArrayList<>(2);
        list.add("a");
        list.add("b");
        map.put("1", list);
        List<String> list2 = map.get("1");
        list2.add("4");
        return "测试有用";
    }

    @Override
    public String mongoTest() {
        //运行MongoDB查询
        Query query = new Query();
        query.fields().include("c10");
        query.with(new Sort(Sort.Direction.DESC, "time_stamp"));
        query.limit(1);
        List<Map> pointMap = mongoTemplate.find(query, Map.class, "SE13_J01_yaoce");
        return null;
    }

    @Override
    public boolean insertMongo() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setPswd("1234");
        mongoTemplate.insert(user,"SE13_J01_yaoce");
        return true;
    }


}