package com.example.junittest.websocketstomp.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/14 10:57
 **/
@Component
@ServerEndpoint(value = "/websocket")
@Slf4j
public class MyWebSocket {
    /** 在綫人數*/
    public static int onlineNumber = 0;
    /** 与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    private Session session;
    /**当前的websocket */
    private static ConcurrentHashMap<String, MyWebSocket> webSocketMap = new ConcurrentHashMap<>();
    private String userId = "";

    @OnOpen
    public void onOpen(Session session) {
        onlineNumber++;
        userId = "zhangsan";
        if (webSocketMap.containsKey(userId)) {
            webSocketMap.remove(userId);
            webSocketMap.put(userId, this);
            //加入set中
        } else {
            webSocketMap.put(userId, this);
            //加入set中
            //在线数加1
        }
        this.session = session;
        log.info("进入链接！当前在线人数{}", onlineNumber);
    }

    @OnMessage
    public void onMessage(String message, Session session) {

        log.info("发送消息");
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现服务器主动推送
     */
    public static void sendInfo(String message) {
        webSocketMap.get("zhangsan").sendMessage(message);

    }

    @OnClose
    public void onClose() {
        onlineNumber--;
        log.info("关闭链接！当前在线人数{}", onlineNumber);
    }
}