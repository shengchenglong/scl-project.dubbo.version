package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.scl.cms.domain.Site;
import com.scl.cms.mapper.SiteMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shengchenglong on 17/3/3.
 */
@Service(protocol = { "dubbo" })
@Transactional
public class SiteServiceImpl implements SiteService {

    @Resource
    private SiteMapper siteMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return siteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Site record) {
        return siteMapper.insert(record);
    }

    @Override
    public int insertSelective(Site record) {
        return siteMapper.insertSelective(record);
    }

    @Override
    public Site selectByPrimaryKey(String id) {
        return siteMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Site record) {
        return siteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Site record) {
        return siteMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<Site> listChildSitesByParentId(String parentId) {
        return siteMapper.listChildSitesByParentId(parentId);
    }


    @Override
    public List<Site> getAllParentSiteWithChildrenSite() {
        return siteMapper.getAllParentSiteWithChildrenSite();
    }

    /**
     * 批量插入站点
     * @param sites
     * @return
     */
    @Override
    public int insertBatch(List<Site> sites) {
        return siteMapper.insertBatch(sites);
    }

    /**
     * 批量更新站点
     * @param sites
     * @return
     */
    @Override
    public int updateBatchByIdSelective(List<Site> sites, String parentId) {
        List<String> ids = getAllIdByParentIds(new String[]{ parentId });
        int num = siteMapper.deleteBatchById(ids);
        num = siteMapper.insertBatch(sites);
        return num;
    }

    /**
     * 根据id批量删除
     *
     * @param ids
     *
     * @return
     */
    @Override
    public int deleteBatchById(List<String> ids) {
        String[] allId = new String[ids.size()];
        for(int i = 0; i < ids.size(); i ++) {
            allId[i] = ids.get(i);
        }
        return siteMapper.deleteBatchById(getAllIdByParentIds(allId));
    }

    /**
     * @param parendIds 父站点的id
     * @return          所有站点id（当前父站点的id，和 子站点的id）
     */
    private List<String> getAllIdByParentIds(String[] parendIds) {
        List<String> ids = new ArrayList<String>();
        for(String parentId : parendIds) {
            ids.add(parentId); // 添加父站点id

            List<Site> childSites = siteMapper.listChildSitesByParentId(parentId);
            for(Site childSite : childSites) {
                ids.add(childSite.getId()); // 添加子站点id
            }
        }
        return ids;
    }
}
