package com.scl.eum;

/**
 * 状态值：<br/>
 * 0: 正常 <br/>
 * 1: 异常 <br/>
 * 
 * @author shengchenglong
 *
 */
public enum EnumStatus {

	NORMAL(0), ABNORMAL(1);

	private Integer value;

	private EnumStatus(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
