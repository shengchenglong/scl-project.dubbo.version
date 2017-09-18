package com.scl.cms.service;

import com.scl.cms.domain.ColumnItem;

import java.util.List;

public interface ColumnItemService {
    int deleteByPrimaryKey(String id);

    int insert(ColumnItem record);

    int insertSelective(ColumnItem record);

    ColumnItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ColumnItem record);

    int updateByPrimaryKey(ColumnItem record);

    /**
     * 根据columcId查询columnItem
     * @param columnId
     * @return
     */
    List<ColumnItem> listColumnItemsByColumnId(String columnId);
}