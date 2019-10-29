package com.example.junittest.enumer;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月19日
 * @功能描述：日志状态类型
 */
public enum LogType {
	/**
	 * 日志类型      LOGIN 登录日志	 ACCESS  记录日志	 OPERA  操作日志
	 */
	UNKNOWN("unknown"), LOGIN("login"), ACCESS("access"), OPERA("opera");

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	LogType(String s) {
		this.value = s;
	}
}
