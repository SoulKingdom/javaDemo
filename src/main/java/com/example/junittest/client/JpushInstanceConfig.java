package com.example.junittest.client;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import com.example.junittest.config.JpushConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description 自动注入JPushClient极光配置
 *  @author HaoXin.Liu
 *  @date 2019/11/1 13:21
 **/
@Component
public class JpushInstanceConfig {
    @Resource
    private JpushConfig jpushConfig;

    /**
      * 极光推送信息配置
      *
      * @dept 上海软件研发中心
      * @return JPushClient 极光推送客户端类
      * @author HaoXin.Liu
      * @date 2019/11/1 13:25
      **/
    @Bean
    public JPushClient jpushClient() {
        //推送对应参数（secret,appKey,proxy,极光同送默认初始化客户端)
        JPushClient jpushClient = new JPushClient(jpushConfig.getMasterSecret(), jpushConfig.getAppKey(), null, ClientConfig.getInstance());
        return jpushClient;
    }
}