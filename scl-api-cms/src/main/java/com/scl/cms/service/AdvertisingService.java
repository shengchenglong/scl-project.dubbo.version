package com.scl.cms.service;

import com.scl.cms.domain.Advertising;
import com.scl.cms.domain.AdvertisingExample;

import java.util.List;

public interface AdvertisingService {

    int countByExample(AdvertisingExample example);

    int deleteByPrimaryKey(String id);

    int insert(Advertising record);

    int insertSelective(Advertising record);

    List<Advertising> selectByExampleWithRowbounds(AdvertisingExample example);

    List<Advertising> selectByExample(AdvertisingExample example);

    Advertising selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Advertising record);

    int updateByPrimaryKey(Advertising record);

    /**
     * 根据siteCode和columnCode查询轮播图（查询出来的是有效轮播图）
     * @param siteCode
     * @param columnCode
     * @return
     */
    List<Advertising> listBySiteCodeAndColumnCode(String siteCode, String columnCode);
}