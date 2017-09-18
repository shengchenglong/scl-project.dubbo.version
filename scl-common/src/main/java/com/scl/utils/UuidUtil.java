package com.scl.utils;

import java.util.UUID;

public class UuidUtil {
	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String generateID() {
		String uid = UUID.randomUUID().toString();
		uid = uid.replaceAll("-", "");
		return uid;
	}
}
