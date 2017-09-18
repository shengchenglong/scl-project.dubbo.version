package com.scl.resultType;

import java.io.Serializable;

public class MsgBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Boolean success;
	
	private String code;
	
	private Object object;
	
	public MsgBean(Boolean success) {
		super();
		this.success = success;
	}
	
	public MsgBean(Boolean success, String code, Object object) {
		super();
		this.success = success;
		this.code = code;
		this.object = object;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

}
