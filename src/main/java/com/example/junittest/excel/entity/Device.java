package com.example.junittest.excel.entity;

import com.example.junittest.excel.annotation.ChineseName;
import com.example.junittest.excel.annotation.ColumnID;
import com.example.junittest.excel.annotation.ExcelFileName;
import lombok.Data;

/**
 *  @dept 上海软件研发中心
 *  @description 设备信息
 *  @author HaoXin.Liu
 *  @date 2019/11/4 13:35
 **/
@ExcelFileName("设备管理")
@Data
public class Device {
    @ColumnID
    @ChineseName("设备Id")
    private String deviceId;
    @ChineseName("设备名称")
    private String deivecName;
    @ChineseName("设备图片")
    private String devicePic;
}