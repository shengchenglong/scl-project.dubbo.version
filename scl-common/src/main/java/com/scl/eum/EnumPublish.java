package com.scl.eum;

/**
 * Created by shengchenglong on 17/3/3.
 *
 * 发布状态：
 * -1 未发布
 * 0  已录入
 * 1  已发布
 */
public enum EnumPublish {

    ENTERING(0), PUBLISHED(1), UNPUBLISHED(-1);

    private Integer value;

    private EnumPublish(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
