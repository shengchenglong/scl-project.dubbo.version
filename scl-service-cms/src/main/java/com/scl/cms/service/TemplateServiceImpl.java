package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scl.cms.domain.Advertising;
import com.scl.cms.domain.Template;
import com.scl.cms.mapper.TemplateMapper;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by shengchenglong on 17/4/6.
 */
@Service(protocol = "dubbo")
@Transactional
public class TemplateServiceImpl implements TemplateService {

    @Resource
    private TemplateMapper templateMapper;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public int deleteByPrimaryKey(String id) {
        return templateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Template record) {
        return templateMapper.insert(record);
    }

    @Override
    public int insertSelective(Template record) {
        return templateMapper.insertSelective(record);
    }

    @Override
    public Template selectByPrimaryKey(String id) {
        return templateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Template record) {
        return templateMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Template record) {
        return templateMapper.updateByPrimaryKey(record);
    }

    /**
     * 分页查询Template
     *
     * @param pageInfo
     * @param map
     *
     * @return
     */
    @Override
    public PageInfo<Template> listPage(PageInfo<Template> pageInfo, Map<String, Object> map) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Template> list = templateMapper.listPage(map);
        PageInfo<Template> resultPage = new PageInfo<Template>(list);
        return resultPage;
    }

}
