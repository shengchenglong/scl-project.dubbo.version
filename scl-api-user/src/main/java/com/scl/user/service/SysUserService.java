package com.scl.user.service;

import com.scl.user.domain.SysUser;

/**
 * 用户（后台管理用户）接口
 * @author shengchenglong
 *
 */
public interface SysUserService {
	
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    
    SysUser selectByUsername(String username);

}
