package com.scl.cms.service;

import com.scl.cms.domain.Column;

import java.util.List;

public interface ColumnService {
    int deleteByPrimaryKey(String id);

    int insert(Column record);

    int insertSelective(Column record);

    Column selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);

    /**
     * 根据columnCode查询栏目（联合查询详情items）
     * @param columnCode
     * @param siteCode
     * @return
     */
    List<Column> listWithColumnItemsByCode(String columnCode, String siteCode);

    /**
     * 根据父栏目code查询栏目（联合查询详情items）
     * @param parentCode
     * @param siteCode
     * @return
     */
    List<Column> listWithColumnItemsByParentCode(String parentCode, String siteCode);
}