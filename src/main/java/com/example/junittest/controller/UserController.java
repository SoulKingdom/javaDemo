package com.example.junittest.controller;

import com.example.junittest.entity.User;
import com.example.junittest.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  @dept 上海软件研发中心
 *  @description 用户控制层
 *  @author HaoXin.Liu
 *  @date 2019/9/2 14:30
 **/
@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("user")
    public String countUser(@RequestBody User user) {
        Integer count = userService.countUser();
        return String.valueOf(count);
    }
}