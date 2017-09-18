package com.scl.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.scl.user.domain.SysResource;
import com.scl.user.domain.SysRole;
import com.scl.user.mapper.SysResourceMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 资源接口实现类
 * @author shengchenglong
 *
 */
@Service(protocol = { "dubbo" })
@Transactional
public class SysResourceServiceImpl implements SysResourceService {
	
	@Resource
	private SysResourceMapper resourceMapper;

	@Override
	public int deleteByPrimaryKey(String id) {
		return resourceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysResource record) {
		return resourceMapper.insert(record);
	}

	@Override
	public int insertSelective(SysResource record) {
		return resourceMapper.insertSelective(record);
	}

	@Override
	public SysResource selectByPrimaryKey(String id) {
		return resourceMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysResource record) {
		return resourceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysResource record) {
		return resourceMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<SysResource> getByRoles(List<SysRole> roles) {
		return resourceMapper.getByRoles(roles);
	}

	@Override
	public List<SysResource> getAll() {
		return resourceMapper.getAll();
	}

	@Override
	public SysResource selectByResourceName(String resourceName) {
		return resourceMapper.selectByParam(resourceName, null, null, null);
	}

	@Override
	public SysResource selectByResourceCode(String resourceCode) {
		return resourceMapper.selectByParam(null, resourceCode, null, null);
	}

	@Override
	public SysResource selectByResourceUrl(String resourceUrl) {
		return resourceMapper.selectByParam(null, null, resourceUrl, null);
	}

	@Override
	public SysResource selectByResourcePermission(String permission) {
		return resourceMapper.selectByParam(null, null, null, permission);
	}

}
