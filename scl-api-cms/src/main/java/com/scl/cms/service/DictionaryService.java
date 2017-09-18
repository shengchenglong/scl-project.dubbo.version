package com.scl.cms.service;


import com.github.pagehelper.PageInfo;
import com.scl.cms.domain.Dictionary;

import java.util.List;
import java.util.Map;

/**
 * Created by shengchenglong on 17/3/7.
 */
public interface DictionaryService {
    int deleteByPrimaryKey(String id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    /**
     * 根据父字典id查询字典
     * @param parentId
     * @return
     */
    List<Dictionary> listChildrenDictByParentId(String parentId);

    /**
     *  根据父字典code查询字典
     * @param code
     * @return
     */
    Dictionary getByCodeWithChildren(String code);

    /**
     * 查询所有字典 联合查询子字典
     * @return
     */
    List<Dictionary> getAll();

    /**
     * 根据字典code查询字典
     * @param code
     * @return
     */
    Dictionary getByCode(String code);

    /**
     * 分页查询字典
     *
     * @param pageInfo
     * @param map
     * @return
     */
    PageInfo<Dictionary> listPage(PageInfo<Dictionary> pageInfo, Map<String, Object> map);
}
