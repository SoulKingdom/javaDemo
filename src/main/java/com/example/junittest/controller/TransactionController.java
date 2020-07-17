package com.example.junittest.controller;

import com.example.junittest.entity.User;
import com.example.junittest.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/13 15:06
 **/
@Api(description = "用户接口")
@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Resource
    private TransactionService transactionService;

    /**
     * 事务传递性1
     * @param user
     * @return
     */
    @PostMapping("transmitone")
    public String countUser(User user) {
        transactionService.methodA();
        return String.valueOf(1);
    }
}