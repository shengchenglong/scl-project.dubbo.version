package com.scl.cms.mapper;

import com.scl.cms.domain.Advertising;
import com.scl.cms.domain.Site;
import com.scl.cms.domain.Template;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

@Mapper
public interface TemplateMapper {
    int deleteByPrimaryKey(String id);

    int insert(Template record);

    int insertSelective(Template record);

    Template selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Template record);

    int updateByPrimaryKey(Template record);


    List<Template> listPage(Map<String, Object> map);


}