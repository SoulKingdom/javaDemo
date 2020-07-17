package com.example.junittest.websocketstomp.controller;

import com.example.junittest.websocketstomp.entity.ClientServerMessage;
import com.example.junittest.websocketstomp.entity.ServerClientMessage;
import com.example.junittest.websocketstomp.socket.MyWebSocket;
import io.swagger.annotations.Api;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/14 10:54
 **/
@Api(tags = {"WebSocket接口"})
@RestController
@RequestMapping("/mysocket")
public class WebSocketController {

    @MessageMapping("/helloTh")
    @SendTo("/nasus/getResponse")
    public ServerClientMessage say(ClientServerMessage message) throws InterruptedException {
        Thread.sleep(3000);
        return new ServerClientMessage("hello," + message.getName() + "!");
    }
}