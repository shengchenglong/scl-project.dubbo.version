package com.scl.cms.mapper;

import com.scl.cms.domain.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DictionaryMapper {
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
    List<Dictionary> listChildrenDictByParentId(@Param("id") String parentId);

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
     * 分页查询
     * @param map
     * @return
     */
    List<Dictionary> listPage(Map<String, Object> map);
}