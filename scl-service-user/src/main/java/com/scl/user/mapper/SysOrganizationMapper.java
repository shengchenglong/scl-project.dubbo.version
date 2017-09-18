package com.scl.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.scl.user.domain.SysOrganization;

@Mapper
public interface SysOrganizationMapper {
	int deleteByPrimaryKey(String id);

	int insert(SysOrganization record);

	int insertSelective(SysOrganization record);

	SysOrganization selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysOrganization record);

	int updateByPrimaryKey(SysOrganization record);
}