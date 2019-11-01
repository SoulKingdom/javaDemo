package com.example.junittest.controller;

import cn.jpush.api.push.PushResult;
import com.example.junittest.message.entity.MessageDTO;
import com.example.junittest.util.JpushUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 *  @dept 上海软件研发中心
 *  @description 极光推送测试
 *  @author HaoXin.Liu
 *  @date 2019/11/1 14:51
 **/
@RequestMapping("push")
@RestController
@Slf4j
public class PushController {
    @Resource
    private JpushUtil jpushUtil;

    @PostMapping("/sendPush")
    public Map sendPush(MessageDTO messageDto) {
        //获取推送信息
        PushResult pushResult = jpushUtil.sendPushAllMessage(messageDto);
        log.info("Got result - " + pushResult);
        Map<String,String> para = new HashMap<>(2);
        para.put("code", "0");
        para.put("msg", "推送成功");
        return para;
    }
}