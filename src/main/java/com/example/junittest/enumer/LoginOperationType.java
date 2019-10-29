package com.example.junittest.enumer;
/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月19日
 * @功能描述：登陆操作状态枚举类型
 */
public enum LoginOperationType {
	/**
	 * 操作类型     LOGIN 登入 		LOGOUT登出
	 */
	UNKNOWN("unknown"),LOGIN("login"),LOGOUT("logout");
	
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	LoginOperationType(String s) {
		this.value = s;
	}
}
