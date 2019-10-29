package com.example.junittest.annotation;

import com.example.junittest.enumer.LogType;
import com.example.junittest.enumer.LoginOperationType;
import com.example.junittest.enumer.OperaLogType;

import java.lang.annotation.*;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月19日
 * @功能描述：登陆日志 注解
 */
@Documented
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(LogOperats.class)
public @interface LogOperat {
	String detail() default "";

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：日志等级
	 * @描述：
	 * @返回值：等级类型
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	int level() default 0;

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：操作类型(enum)  主要有：LOGIN,LOGOUT
	 * @描述：
	 * @返回值：LoginOperationType 枚举类型
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	LoginOperationType loginOperationType() default LoginOperationType.UNKNOWN;

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：发起请求的终端应用类型
	 * @描述：
	 * @返回值：String 	发起请求的终端应用类型
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	String sourceType() default "WEB";

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：日志类型
	 * @描述：
	 * @返回值：LogType	日志类型 
	 * 	      		LOGIN 	登录日志
	 * 		  		ACCESS  记录日志
	 * 		  		OPERA  	操作日志
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月20日
	 */
	LogType logType();
	/**
	 * 操作类型
	 * @部门：上海软件研发中心
	 * @功能：操作日志类型
	 * @描述：
	 * @返回值：OperaLogType	操作类型
	 * 				INSERT 	增加
	 * 				DELETE 	删除
	 * 				UPDATE 	修改
	 * 				SELECT 	查询
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月20日
	 */
	OperaLogType operationType() default OperaLogType.UNKNOWN;
}
