package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scl.cms.domain.Dictionary;
import com.scl.cms.mapper.DictionaryMapper;
import com.scl.cms.mapper.SiteMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by shengchenglong on 17/3/7.
 */
@Service(protocol = {"dubbo"})
@Transactional
public class DictionaryServiceImpl implements DictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return dictionaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Dictionary record) {
        return dictionaryMapper.insert(record);
    }

    @Override
    public int insertSelective(Dictionary record) {
        return dictionaryMapper.insertSelective(record);
    }

    @Override
    public Dictionary selectByPrimaryKey(String id) {
        return dictionaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dictionary record) {
        return dictionaryMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据父字典id查询字典
     *
     * @param parentId
     *
     * @return
     */
    @Override
    public List<Dictionary> listChildrenDictByParentId(String parentId) {
        return dictionaryMapper.listChildrenDictByParentId(parentId);
    }

    /**
     *  根据父字典code查询字典
     *
     * @param code
     *
     * @return
     */
    @Override
    public Dictionary getByCodeWithChildren(String code) {
        return dictionaryMapper.getByCodeWithChildren(code);
    }

    /**
     * 查询所有字典 联合查询子字典
     *
     * @return
     */
    @Override
    public List<Dictionary> getAll() {
        return dictionaryMapper.getAll();
    }

    /**
     * 根据字典code查询字典
     *
     * @param code
     *
     * @return
     */
    @Override
    public Dictionary getByCode(String code) {
        return dictionaryMapper.getByCode(code);
    }

    /**
     * 分页查询字典
     *
     * @param pageInfo
     * @param map
     *
     * @return
     */
    @Override
    public PageInfo<Dictionary> listPage(PageInfo<Dictionary> pageInfo, Map<String, Object> map) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<Dictionary> list = dictionaryMapper.listPage(map);
        PageInfo resPage = new PageInfo(list);
        return resPage;
    }
}
