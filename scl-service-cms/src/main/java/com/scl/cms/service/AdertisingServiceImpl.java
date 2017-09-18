package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.scl.cms.domain.Advertising;
import com.scl.cms.domain.AdvertisingExample;
import com.scl.cms.mapper.AdvertisingMapper;
import com.scl.eum.EnumDelete;
import com.scl.eum.EnumPublish;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by shengchenglong on 17/4/6.
 */
@Service(protocol = "dubbo")
@Transactional
public class AdertisingServiceImpl implements AdvertisingService {

    @Resource
    private AdvertisingMapper advertisingMapper;

    @Override
    public int countByExample(AdvertisingExample example) {
        return advertisingMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return advertisingMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Advertising record) {
        return advertisingMapper.insert(record);
    }

    @Override
    public int insertSelective(Advertising record) {
        return advertisingMapper.insertSelective(record);
    }

    @Override
    public List<Advertising> selectByExampleWithRowbounds(AdvertisingExample example) {
        return null;
    }

    @Override
    public List<Advertising> selectByExample(AdvertisingExample example) {
        return advertisingMapper.selectByExample(example);
    }

    @Override
    public Advertising selectByPrimaryKey(String id) {
        return advertisingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Advertising record) {
        return advertisingMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Advertising record) {
        return advertisingMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据siteCode和columnCode查询轮播图（查询出来的是有效轮播图）
     * @param siteCode
     * @param columnCode
     *
     * @return
     */
    @Override
    public List<Advertising> listBySiteCodeAndColumnCode(String siteCode, String columnCode) {
        Date date = new Date();
        AdvertisingExample example = new AdvertisingExample();
        example.or().andSiteCodeEqualTo(siteCode).andColumnCodeEqualTo(columnCode)
                .andWhetherDeleteEqualTo(EnumDelete.NO.getValue()).andPublishStatusEqualTo(EnumPublish.PUBLISHED.getValue())
                .andBeginTimeLessThanOrEqualTo(date).andEndTimeGreaterThanOrEqualTo(date);
        return advertisingMapper.selectByExample(example);
    }
}
