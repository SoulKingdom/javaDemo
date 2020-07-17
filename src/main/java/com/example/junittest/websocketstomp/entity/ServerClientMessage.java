package com.example.junittest.websocketstomp.entity;

/**
 *  @dept 上海软件研发中心
 *  @description 服务器发送给客户端 消息
 *  @author HaoXin.Liu
 *  @date 2020/7/15 17:47
 **/
public class ServerClientMessage {

    private String responseMessage;

    public ServerClientMessage() {
        super();
    }

    public ServerClientMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}