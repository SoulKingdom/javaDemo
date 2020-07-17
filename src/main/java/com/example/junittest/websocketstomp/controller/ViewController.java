package com.example.junittest.websocketstomp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2020/7/15 18:36
 **/
@Controller
public class ViewController {

    @GetMapping("/nasus")
    public String getView() {
        return "nasus";
    }

}