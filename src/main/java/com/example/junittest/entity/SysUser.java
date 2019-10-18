package com.example.junittest.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *  @dept 上海软件研发中心
 *  @description 用户
 *  @author HaoXin.Liu
 *  @date 2019/10/18 14:11
 **/
@Data
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;

    // 省略getter/setter
}
