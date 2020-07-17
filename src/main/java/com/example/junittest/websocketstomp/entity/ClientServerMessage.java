package com.example.junittest.websocketstomp.entity;

/**
 *  @dept 上海软件研发中心
 *  @description 客户端发送给服务器 消息
 *  @author HaoXin.Liu
 *  @date 2020/7/15 17:46
 **/
public class ClientServerMessage {

    private String name;

    public ClientServerMessage() {
    }

    public ClientServerMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ClientServerMessage{" +
                "name='" + name + '\'' +
                '}';
    }
}