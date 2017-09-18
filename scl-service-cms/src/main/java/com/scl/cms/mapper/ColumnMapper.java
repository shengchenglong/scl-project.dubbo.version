package com.scl.cms.mapper;

import com.scl.cms.domain.Column;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColumnMapper {
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
    List<Column> listColumnWithItemsByCode(String columnCode, String siteCode);

    /**
     * 根据父栏目code查询栏目（联合查询详情items）
     * @param parentCode
     * @param siteCode
     * @return
     */
    List<Column> listColumnWithItemsByParentCode(String parentCode, String siteCode);
}