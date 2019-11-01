package com.example.junittest.message.entity;

import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;

/**
 * 使用别名:
 * 用于给某特定用户推送消息。别名，可以近似地被认为，是用户帐号里的昵称。
 * 使用标签:
 * 用于给某一群人推送消息。
 * 标签类似于博客里为文章打上 tag ，即为某资源分类。
 *
 *  @dept 上海软件研发中心
 *  @author HaoXin.Liu
 *  @date 2019/11/1 13:37
 **/
public class JPushClientPC {
    /**
     * 发送所有的消息  全部人
     *
     * @param messageDto
     * @return
     */
    public static PushPayload buildPushObject_all_message(MessageDTO messageDto) {
        return PushPayload.newBuilder()
                //设置接受的平台
                .setPlatform(Platform.all())
                //Audience设置为all，说明采用广播方式推送，所有用户都可以接收到
                .setAudience(Audience.all())
                //.setNotification(Notification.alert(JSON.toJSONString(responseNoticeMessage)))
                //内部消息不显示，类似web socket
                //.setMessage(Message.content(JSON.toJSONString(messageDto.getNoticeContext())))
                .setNotification(Notification.alert(JSON.toJSONString(messageDto.getNoticeContext())))
                .build();
    }

    /**
     * 根据别名集合 推送
     *
     * @param messageDto  别名List
     * @return
     */
    public static PushPayload buildPushObject_all_alias_message(MessageDTO messageDto) {
        return PushPayload.newBuilder()
                //设置接受的平台
                .setPlatform(Platform.all())
                //Audience设置别名，别名用户都可以接收到
                .setAudience(Audience.alias(messageDto.getUserCodeList()))
                //.setNotification(Notification.alert(JSON.toJSONString(responseNoticeMessage)))
                //内部消息不显示，类似web socket
                //.setMessage(Message.content(JSON.toJSONString(messageDto.getNoticeContext())))
                .setNotification(Notification.alert(messageDto.getNoticeContext()))
                .build();
    }

    /**
     * 根据别名 推送
     *
     * @return
     */
    public static PushPayload buildPushObject_all_single_alias_message(MessageDTO messageDto) {
        return PushPayload.newBuilder()
                //设置接受的平台
                .setPlatform(Platform.all())
                //单点推送
                .setAudience(Audience.alias(messageDto.getUserName()))
                //.setNotification(Notification.alert(JSON.toJSONString(responseNoticeMessage)))
                //内部消息不显示，类似web socket
                .setMessage(Message.content(JSON.toJSONString(messageDto)))
                .build();
    }

    /**
     * 根据标签集合推送
     *
     * @param messageDto 消息参数
     * @return
     */
    public static PushPayload buildPushObject_all_tags_message(MessageDTO messageDto) {
        return PushPayload.newBuilder()
                //设置接受的平台
                .setPlatform(Platform.all())
                //设置标签
                .setAudience(Audience.tag(messageDto.getTags()))
                .setNotification(Notification.alert(messageDto.getNoticeContext()))
                //.setMessage(Message.content(JSON.toJSONString(responseNoticeMessage)))  //内部消息不显示，类似web socket
                .build();
    }

    /**
     * 根据标签推送
     *
     * @param messageDto 消息参数
     * @return
     */
    public static PushPayload buildPushObject_all_tag_message(MessageDTO messageDto) {
        return PushPayload.newBuilder()
                //设置接受的平台
                .setPlatform(Platform.all())
                //设置tag名称
                .setAudience(Audience.tag(messageDto.getTag()))
                //设置响应内容
                .setNotification(Notification.alert(messageDto.getNoticeContext()))
                //.setMessage(Message.content(JSON.toJSONString(responseNoticeMessage)))  //内部消息不显示，类似web socket
                .build();
    }
}