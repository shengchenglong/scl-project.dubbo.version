package com.scl.cms.mapper;

import com.scl.cms.domain.Advertising;
import com.scl.cms.domain.AdvertisingExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface AdvertisingMapper {
    int countByExample(AdvertisingExample example);

    int deleteByPrimaryKey(String id);

    int insert(Advertising record);

    int insertSelective(Advertising record);

    List<Advertising> selectByExampleWithRowbounds(AdvertisingExample example, RowBounds rowBounds);

    List<Advertising> selectByExample(AdvertisingExample example);

    Advertising selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Advertising record);

    int updateByPrimaryKey(Advertising record);
}