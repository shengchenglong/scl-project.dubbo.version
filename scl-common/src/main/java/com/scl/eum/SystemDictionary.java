package com.scl.eum;

/**
 * Created by shengchenglong on 17/3/8.
 * 常用父级字典code
 */
public enum SystemDictionary {

    LANGUAGE("language");

    private String code;

    private SystemDictionary(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
