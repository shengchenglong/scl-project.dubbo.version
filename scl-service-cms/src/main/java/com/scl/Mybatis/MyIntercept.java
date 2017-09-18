package com.scl.Mybatis;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * Created by shengchenglong on 17/5/5.
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
        RowBounds.class, ResultHandler.class }) })
public class MyIntercept implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(MyIntercept.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 拿取参数
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];
        RowBounds rowBounds = (RowBounds) args[2];
        ResultHandler resultHandler = (ResultHandler) args[3];



        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);

    }

    @Override
    public void setProperties(Properties properties) {
        Set set = properties.keySet();
        Iterator i = set.iterator();
        while(i.hasNext()) {
            logger.info(String.valueOf(properties.get(i.next())) + "+++++++++++");
        }
    }
}
