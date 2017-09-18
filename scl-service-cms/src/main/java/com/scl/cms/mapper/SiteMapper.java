package com.scl.cms.mapper;

import com.scl.cms.domain.Site;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SiteMapper {
    int deleteByPrimaryKey(String id);

    int insert(Site record);

    int insertSelective(Site record);

    Site selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);

    /**
     * 根据参数来查询站点
     * @param map
     * @map
     *
     * @return
     */
    List<Site> listByParam(Map<String, Object> map);

    /**
     * 根据父站点id来查询子站点
     * @param parentId
     * @return
     */
    List<Site> listChildSitesByParentId(@Param("id") String parentId);

    /**
     * 获取所有站点数据 联合查询出子站点
     * @return
     */
    List<Site> getAllParentSiteWithChildrenSite();

    /**
     * 批量插入站点
     * @param sites
     * @return
     */
    int insertBatch(@Param("sites") List<Site> sites);

    /**
     * 批量更新站点
     * @param sites
     * @return
     */
    //int updateBatchByIdSelective(@Param("sites") List<Site> sites);

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    int deleteBatchById(@Param("ids") List<String> ids);

}