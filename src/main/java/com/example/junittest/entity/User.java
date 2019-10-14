package com.example.junittest.entity;

import lombok.Data;

/**
 *  @dept 上海软件研发中心
 *  @description 用户信息
 *  @author HaoXin.Liu
 *  @date 2019/8/21 18:43
 **/
@Data
public class User {
    private String userName;
    private String pswd;

    public User() {
        super();
    }

    public User(String userName, String pswd) {
        this.userName = userName;
        this.pswd = pswd;
    }

}