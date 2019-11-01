package com.example.junittest.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  @dept 上海软件研发中心
 *  @description 极光推送配置
 *  @author HaoXin.Liu
 *  @date 2019/11/1 10:55
 **/
@Data
@Component
@ConfigurationProperties(prefix = "jpush")
public class JpushConfig {
    /**
     * 极光申请 app key
     */
    private String appKey;
    /**
     * 极光申请的 secret
     */
    private String masterSecret;
}