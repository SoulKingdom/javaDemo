package com.example.junittest.service.impl;

import com.example.junittest.service.TestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/8/21 17:56
 **/
@Service
public class TestServiceImpl implements TestService {



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
}