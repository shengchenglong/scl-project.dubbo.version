package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.scl.cms.domain.Column;
import com.scl.cms.mapper.ColumnMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shengchenglong on 17/4/5.
 */
@Service(protocol = "dubbo")
@Transactional
public class ColumnServiceImpl implements ColumnService {

    @Resource
    private ColumnMapper columnMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return columnMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Column record) {
        return columnMapper.insert(record);
    }

    @Override
    public int insertSelective(Column record) {
        return columnMapper.insertSelective(record);
    }

    @Override
    public Column selectByPrimaryKey(String id) {
        return columnMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Column record) {
        return columnMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Column record) {
        return columnMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据columnCode查询栏目（联合查询详情items）
     *
     * @param columnCode
     * @param siteCode
     *
     * @return
     */
    @Override
    public List<Column> listWithColumnItemsByCode(String columnCode, String siteCode) {
        return columnMapper.listColumnWithItemsByCode(columnCode, siteCode);
    }

    /**
     * 根据父栏目code查询栏目（联合查询详情items）
     *
     * @param parentCode
     * @param siteCode
     *
     * @return
     */
    @Override
    public List<Column> listWithColumnItemsByParentCode(String parentCode, String siteCode) {
        return columnMapper.listColumnWithItemsByParentCode(parentCode, siteCode);
    }

}
