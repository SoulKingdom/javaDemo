package com.example.junittest.message.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *  @dept 上海软件研发中心
 *  @description 推送传送消息
 *  @author HaoXin.Liu
 *  @date 2019/11/1 13:56
 **/
@Component
@Data
public class MessageDTO {
    /**
     * 用户编码集合
     */
    private List<String> userCodeList;
    /**
     * 根据标签集合
     */
    private List<String> tags;
    /**
     * 根据标签
     */
    private String tag;
    /**
     * 单个用户
     */
    private String userName;
    /**
     * 消息内容
     */
    private String noticeContext;

}