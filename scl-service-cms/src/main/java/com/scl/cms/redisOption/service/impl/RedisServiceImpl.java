package com.scl.cms.redisOption.service.impl;

import com.scl.cms.domain.Dictionary;
import com.scl.cms.mapper.DictionaryMapper;
import com.scl.cms.redisOption.service.RedisService;
import com.scl.eum.RedisKey;
import com.scl.eum.SystemDictionary;
import com.scl.utils.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shengchenglong on 17/5/8.
 */
@Service
public class RedisServiceImpl implements RedisService {

    private Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);
    @Resource
    private JedisConnectionFactory jedisConnectionFactory;
    @Resource
    private DictionaryMapper dictionaryMapper;

    @Override
    public void addToRedis() {
        addDictionary();
    }

    private void addDictionary() {
        String languageDic = SystemDictionary.LANGUAGE.getCode();
        Dictionary dictionary = dictionaryMapper.getByCodeWithChildren(languageDic);
        if(dictionary != null) {
            List<Dictionary> languages = dictionary.getChildrenDict();

            byte[] bytes = SerializeUtil.serialize(languages);
            RedisConnection connection = jedisConnectionFactory.getConnection();
            connection.set(RedisKey.LANGUAGE_CODE_ALL.toString().getBytes(), bytes);
            logger.info("---------------------------------Redis存储语言版本对象  完成------------------------------------------");
            // List<Dictionary> dicts = (List<Dictionary>) SerializeUtil.unserialize(connection.get(RedisKey.LANGUAGE_CODE_ALL.toString().getBytes()));
            if(connection != null) {
                connection.close();
            }
        } else {
            logger.info("---------------------------------Redis存储语言版本对象  失败------------------------------------------");
            logger.info("---------------------------------无法获取语言字典------------------------------------------");
        }
    }

}
