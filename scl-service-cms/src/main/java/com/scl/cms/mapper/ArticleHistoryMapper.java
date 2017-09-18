package com.scl.cms.mapper;

import com.scl.cms.domain.ArticleHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleHistoryMapper {
    int deleteByPrimaryKey(String id);

    int insert(ArticleHistory record);

    int insertSelective(ArticleHistory record);

    ArticleHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleHistory record);

    int updateByPrimaryKeyWithBLOBs(ArticleHistory record);

    int updateByPrimaryKey(ArticleHistory record);
}