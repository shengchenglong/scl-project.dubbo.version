package com.scl.user.service;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scl.user.domain.SysUser;
import com.scl.user.mapper.SysUserMapper;


/**
 * 后台管理用户接口实现类
 * @author shengchenglong
 *
 */
@Service(protocol = { "dubbo" })
@Transactional
public class SysUserServiceImpl implements SysUserService {

	@Resource
	private SysUserMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysUser record) {
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(SysUser record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public SysUser selectByPrimaryKey(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SysUser record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysUser record) {
		return userMapper.updateByPrimaryKey(record);
	}

	
	@Override
	public SysUser selectByUsername(String username) {
		return userMapper.selectByUsername(username);
	}

}
