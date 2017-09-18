package com.scl.user.mapper;


import com.scl.user.domain.SysModule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysModuleMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysModule record);

    int insertSelective(SysModule record);

    SysModule selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysModule record);

    int updateByPrimaryKey(SysModule record);
}