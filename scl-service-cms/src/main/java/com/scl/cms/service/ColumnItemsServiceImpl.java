package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.scl.cms.domain.ColumnItem;
import com.scl.cms.mapper.ColumnItemMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shengchenglong on 17/4/5.
 */
@Service(protocol = "dubbo")
@Transactional
public class ColumnItemsServiceImpl implements ColumnItemService {

    @Resource
    private ColumnItemMapper columnItemMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return columnItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ColumnItem record) {
        return columnItemMapper.insert(record);
    }

    @Override
    public int insertSelective(ColumnItem record) {
        return columnItemMapper.insertSelective(record);
    }

    @Override
    public ColumnItem selectByPrimaryKey(String id) {
        return columnItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ColumnItem record) {
        return columnItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ColumnItem record) {
        return columnItemMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据columcId查询columnItem
     * @param columnId
     * @return
     */
    @Override
    public List<ColumnItem> listColumnItemsByColumnId(String columnId) {
        return columnItemMapper.listColumnItemsByColumnId(columnId);
    }
}
