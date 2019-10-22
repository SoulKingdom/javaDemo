package com.example.junittest.controller;

import com.example.junittest.service.ProcedureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *  @dept 上海软件研发中心
 *  @description 存储过程测试
 *  @author HaoXin.Liu
 *  @date 2019/10/21 15:05
 **/
@RestController
@RequestMapping("procedure")
public class ProcedureController {
    @Resource
    private ProcedureService procedureService;
    @PostMapping("/getParam")
    public String getParam() {
        Map<String,String> para = new HashMap<>(1);
        para.put("userId","1");
        String str = procedureService.getParam(para);
        return str;
    }

}