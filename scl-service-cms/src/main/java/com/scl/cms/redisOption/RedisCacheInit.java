package com.scl.cms.redisOption;

import com.scl.cms.redisOption.service.RedisService;
import com.scl.cms.redisOption.service.impl.RedisServiceImpl;
import com.scl.cms.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by shengchenglong on 17/4/12.
 */
@Component
public class RedisCacheInit implements InitializingBean, ApplicationContextAware {

    private Logger logger = LoggerFactory.getLogger(RedisCacheInit.class);
    private ApplicationContext applicationContext;

    @Override
    public void afterPropertiesSet() throws Exception {
        addLangeuagesToRedis();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 将语言版本存入redis
     */
    private void addLangeuagesToRedis() {

        RedisService redisService = applicationContext.getBean(RedisServiceImpl.class);
        redisService.addToRedis();

    }


}
