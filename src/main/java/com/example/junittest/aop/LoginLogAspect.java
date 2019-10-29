package com.example.junittest.aop;

import com.example.junittest.annotation.LogOperat;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月19日
 * @功能描述：登陸日志AOP
 */
@Aspect
@Component
public class LoginLogAspect {
    private final static Logger logger = LoggerFactory.getLogger(LoginLogAspect.class);

    @Pointcut("@annotation(com.example.junittest.annotation.LogOperat)")
    private void loginLog() {
    }

    /**
      * 面向注解切面
      *
      * @dept 上海软件研发中心
      * @param joinPoint 连接点
      * @return 随意信息（暂时不知道）
      * @author HaoXin.Liu
      * @date 2019/10/29 13:59
      **/
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    @Around("loginLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        // 获取注解方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        LogOperat logOperat = methodSignature.getMethod().getAnnotation(LogOperat.class);
        // 执行操作方法
        Object res = null;
        try {
            res = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return res;
    }
    /**
      * 面向方法切面
      * 
      * @dept 上海软件研发中心
      * @param jp 
      * @return
      * @author HaoXin.Liu
      * @date 2019/10/29 13:59
      **/
    @Before("execution(* *ByTestAop(..))")
    public void before(JoinPoint jp) {
       
    }
}
