package com.scl.web.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 树形结构服务接口
 * @author shengchenglong
 */
public interface TreeInterface<T extends BaseTreeObj<T,ID>, ID extends Serializable>{
    /**
     * 获得指定节点下所有归档
     * @param list
     * @param parentId
     * @return
     */
    public List<T> getChildTreeObjects(List<T> list, ID parentId);

    /**
     * 递归列表
     * @param list
     * @param t
     * 上午1:11:57
     */
    public void recursionFn(List<T> list,T t);

    /**
     * 获得指定节点下的所有子节点
     * @param list
     * @param t
     * 上午1:12:55
     */
    public List<T> getChildList(List<T> list,T t);

    /**
     * 判断是否还有下一个子节点
     * @param list
     * @param t
     * @return
     * 上午1:13:43
     */
    public boolean hasChild(List<T> list, T t);
}

