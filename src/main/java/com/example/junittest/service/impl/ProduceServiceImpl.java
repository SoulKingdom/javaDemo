package com.example.junittest.service.impl;

import com.example.junittest.dao.ProcedureDao;
import com.example.junittest.service.ProcedureService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Map;

/**
 *  @dept 上海软件研发中心
 *  @description 存储过程服务
 *  @author HaoXin.Liu
 *  @date 2019/10/21 15:11
 **/
@Service
public class ProduceServiceImpl implements ProcedureService {
    @Resource
    private ProcedureDao procedureDao;
    @Override
    public String getParam(Map<String, String> param) {
        Map<String , String> str =  procedureDao.getParam(param);
        return "123";
    }
}