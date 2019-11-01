package com.example.junittest.util;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.PushPayload;
import com.example.junittest.message.entity.JPushClientPC;
import com.example.junittest.message.entity.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  @dept 上海软件研发中心
 *  @description 极光推送工具类
 *  @author HaoXin.Liu
 *  @date 2019/11/1 14:40
 **/
@Slf4j
@Component
public class JpushUtil {
    @Autowired
    private JPushClient jpushClient;

    /**
     * 推送所有平台 用于广播消息  用于管理员使用
     *
     * @param messageDto 消息
     */
    public PushResult sendPushAllMessage(MessageDTO messageDto) {
        //生成推送的内容
        PushPayload payload = JPushClientPC.buildPushObject_all_message(messageDto);
        return sendPush(payload);
    }

    /**
     * 发送
     * @param payload
     * @return
     */
    private PushResult sendPush(PushPayload payload){
        try {
            //发送消息
            PushResult result = jpushClient.sendPush(payload);
            jpushClient.close();
            return result;
        } catch (Exception e) {
            log.info("sendPushAllAlert ： HTTP Status -=- {}", e.getMessage());
        }
        return null;
    }
}