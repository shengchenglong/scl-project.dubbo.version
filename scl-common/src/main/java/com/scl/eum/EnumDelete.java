package com.scl.eum;

/**
 * 是否删除
 * 0:未删除
 * 1:已删除
 * @author shengchenglong
 */
public enum EnumDelete {
	
	YES(1), NO(0);
	
	private Integer value;
	
	private EnumDelete(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}
}
