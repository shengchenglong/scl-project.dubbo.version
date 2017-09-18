package com.scl.cms.service;

import com.scl.cms.domain.Attach;

import java.util.List;

/**
 * Created by shengchenglong on 17/4/6.
 */
public interface AttachService {

    int deleteByPrimaryKey(String id);

    int insert(Attach record);

    int insertSelective(Attach record);

    Attach selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attach record);

    int updateByPrimaryKey(Attach record);

    /**
     * 根据hostId来查询附件
     * @param hostId
     * @return
     */
    List<Attach> listByHostId(String hostId);
}
