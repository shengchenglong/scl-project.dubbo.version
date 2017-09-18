package com.scl.cms.service;

import com.scl.cms.domain.Site;

import java.util.List;

public interface SiteService {
    int deleteByPrimaryKey(String id);

    int insert(Site record);

    int insertSelective(Site record);

    Site selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);

    /**
     * 根据父站点id来查询子站点
     * @param parentId
     * @return
     */
    List<Site> listChildSitesByParentId(String parentId);

    /**
     * 获取所有站点数据 联合查询出子站点
     * @return 集合中只包含父站点，子站点是父站点属性
     */
    List<Site> getAllParentSiteWithChildrenSite();

    /**
     * 批量插入站点
     * @param sites
     * @return
     */
    int insertBatch(List<Site> sites);

    /**
     * 批量更新站点
     * @param sites
     * @return
     */
    int updateBatchByIdSelective(List<Site> sites, String parentId);

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    int deleteBatchById(List<String> ids);
}