package com.example.junittest.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 *  @dept 上海软件研发中心
 *  @description 队列配置
 *  @author HaoXin.Liu
 *  @date 2019/10/11 11:25
 **/
/*@Configuration*/
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return new Queue("hello");
    }
}