package com.scl.cms.mapper;

import com.scl.cms.domain.Attach;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachMapper {
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