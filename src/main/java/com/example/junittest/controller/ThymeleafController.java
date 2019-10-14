package com.example.junittest.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  @dept 上海软件研发中心
 *  @description TODO
 *  @author HaoXin.Liu
 *  @date 2019/10/14 10:54
 **/
@Api(tags = {"Thymeleaf接口"})
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {

    @RequestMapping("/hello")
    public String hello(Model m) {
        m.addAttribute("name", "thymeleaf");
        return "hello";
    }
}