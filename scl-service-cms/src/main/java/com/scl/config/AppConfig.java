package com.scl.config;

import com.scl.Mybatis.MyIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@ImportResource("classpath:META-INF/spring/*.xml")
public class AppConfig {

    @Bean
    public MyIntercept myIntercept() {
        return new MyIntercept();
    }

}
