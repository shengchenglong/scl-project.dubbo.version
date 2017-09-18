package com.scl.cms.service;

import com.scl.cms.domain.ArticleHistory;

public interface ArticleHistoryService {
    int deleteByPrimaryKey(String id);

    int insert(ArticleHistory record);

    int insertSelective(ArticleHistory record);

    ArticleHistory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ArticleHistory record);

    int updateByPrimaryKeyWithBLOBs(ArticleHistory record);

    int updateByPrimaryKey(ArticleHistory record);
}