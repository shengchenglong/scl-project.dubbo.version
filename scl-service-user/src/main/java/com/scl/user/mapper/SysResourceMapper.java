package com.scl.user.mapper;

import com.scl.user.domain.SysResource;
import com.scl.user.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface SysResourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);
    
    List<SysResource> getByRoles(@Param("roles") List<SysRole> roles);
    
    List<SysResource> getAll();
    
    SysResource selectByParam(@Param("name") String resourceName, @Param("code") String resourceCode, @Param("url") String resourceUrl, @Param("permission") String permission);
    
}