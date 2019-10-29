package com.example.junittest.controller;

import com.example.junittest.annotation.LogOperat;
import com.example.junittest.enumer.LogType;
import com.example.junittest.enumer.LoginOperationType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/28 13:25
 **/
@RestController
@RequestMapping("AOP")
public class AopController {

    /**
      * 面向注解的AOP测试
      *
      * @dept 上海软件研发中心
      * @param
      * @return
      * @author HaoXin.Liu
      * @date 2019/10/29 14:00
      **/
    @LogOperat(detail = "登录日志",logType = LogType.LOGIN,level = 1,loginOperationType = LoginOperationType.LOGIN)
    @RequestMapping(value = "appTestLogin",method = RequestMethod.POST)
    public String aopTestLogin(){
        return "这是用来测试aop是否通过注解调用";
    }
    /**
      * 面向AOP方法测试
      * 
      * @dept 上海软件研发中心
      * @author HaoXin.Liu
      * @date 2019/10/29 14:01
      **/
    @RequestMapping(value = "appTestLogin",method = RequestMethod.POST)
    public String aopTestLoginByTestAop(){
        return "This Test is aop method test！";
    }
}