package com.example.junittest.enumer;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月20日
 * @功能描述：操作日志 状态类型
 */
public enum OperaLogType {
	/**
	 * 操作类型     INSERT 增加	 DELETE 删除	   UPDATE 修改 	SELECT 查询
	 */
	UNKNOWN("unknown"), INSERT("insert"), DELETE("delete"), UPDATE("update"), SELECT("select");

	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	OperaLogType(String s) {
		this.value = s;
	}
}
