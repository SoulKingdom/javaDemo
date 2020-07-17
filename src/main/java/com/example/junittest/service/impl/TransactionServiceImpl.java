package com.example.junittest.service.impl;

import com.example.junittest.dao.UserDao;
import com.example.junittest.entity.UserCond;
import com.example.junittest.service.TransactionBService;
import com.example.junittest.service.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;

/**
 *  @dept 上海软件研发中心
 *  @description 事务传递性
 *  @author HaoXin.Liu
 *  @date 2020/7/13 15:10
 **/
@Service
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private UserDao userDao;
    @Resource
    private TransactionBService transactionBService;

    @Override
    public String methodA() {
        //保存数据
        userDao.update1("3");
        UserCond userCond = new UserCond();
        Map<String, String> map = userDao.getUserMap("3");
        transactionBService.methodB();
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String methodB() {
        //保存数据
        userDao.update1("4");
        Map<String, String> map = userDao.getUserMap("4");
        int a = 1 / 0;
        //TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        return null;
    }
}