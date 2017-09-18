package com.scl.cms.service;

import com.github.pagehelper.PageInfo;
import com.scl.cms.domain.Template;

import java.util.Map;

public interface TemplateService {
    int deleteByPrimaryKey(String id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);

    // Page<Template> listPage(Page<Template> page, Map<String, Object> map);

    /**
     * 分页查询Template
     *
     * @param pageInfo
     * @param map
     * @return
     */
    PageInfo<Template> listPage(PageInfo<Template> pageInfo, Map<String, Object> map);


}