package com.scl.user.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.scl.user.domain.SysMenu;
import com.scl.user.mapper.SysMenuMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shengchenglong on 17/2/20.
 */
@Service(protocol = { "dubbo" })
@Transactional
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private SysMenuMapper menuMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysMenu record) {
        return menuMapper.insert(record);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return menuMapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(String id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return menuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysMenu record) {
        return menuMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysMenu> getAll() {
        return menuMapper.getAll();
    }
}
