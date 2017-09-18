package com.scl.user.service;



import com.scl.user.domain.SysMenu;

import java.util.List;

/**
 * Created by shengchenglong on 17/2/20.
 */
public interface SysMenuService {

    int deleteByPrimaryKey(String id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getAll();
}
