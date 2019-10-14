package com.example.junittest.design.mode.builder;

import lombok.Builder;
import lombok.Data;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/9/5 18:39
 **/
@Builder
@Data
public class UserTo {
    private String userName;
    private String acct;
    private String pswd;
    private String sort;

}