package com.scl.eum;

/**
 * 是否锁定状态
 * 0:未锁定
 * 1:已锁定
 * @author shengchenglong
 */
public enum EnumLock {

	YES(1), NO(0);

	private Integer value;

	private EnumLock(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

}
