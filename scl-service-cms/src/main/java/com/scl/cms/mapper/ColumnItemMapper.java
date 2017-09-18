package com.scl.cms.mapper;

import com.scl.cms.domain.ColumnItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ColumnItemMapper {
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
    List<ColumnItem> listColumnItemsByColumnId(@Param("id")String columnId);
}