package com.example.junittest.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月20日
 * @功能描述：java8新特性  重复注解  封装注解
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogOperats {
	LogOperat[] value();
}
