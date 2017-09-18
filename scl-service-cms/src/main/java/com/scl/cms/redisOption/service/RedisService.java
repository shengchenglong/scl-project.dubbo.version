package com.scl.cms.redisOption.service;

import com.scl.cms.domain.Dictionary;
import com.scl.cms.mapper.DictionaryMapper;

import javax.annotation.Resource;

/**
 * 将一些数据放入redis
 *
 * Created by shengchenglong on 17/5/8.
 */
public interface RedisService {

    void addToRedis();

}
