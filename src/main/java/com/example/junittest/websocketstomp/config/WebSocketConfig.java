package com.example.junittest.websocketstomp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/14 10:53
 **/
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        //注冊一个stomp的节点（endpoint）,并指定使用SockJs协议
        registry.addEndpoint("/endpointNasus").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //广播式配置名为/nasus消息代理，这个消息代理必须和controller中的@sendTo配置的地址前缀一样或全匹配
        registry.enableSimpleBroker("/nasus");
    }
}