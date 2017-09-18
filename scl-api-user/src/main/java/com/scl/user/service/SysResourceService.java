package com.scl.user.service;


import com.scl.user.domain.SysResource;
import com.scl.user.domain.SysRole;

import java.util.List;


/**
 * 资源接口
 * @author shengchenglong
 *
 */
public interface SysResourceService {
	
    int deleteByPrimaryKey(String id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    /**
     * 根据角色来获取资源
     * @return
     */
    List<SysResource> getByRoles(List<SysRole> roles);
    
    List<SysResource> getAll();
    
    SysResource selectByResourceName(String resourceName);
    
    SysResource selectByResourceCode(String resourceCode);
    
    SysResource selectByResourceUrl(String resourceUrl);
    
    SysResource selectByResourcePermission(String permission);
    
}
