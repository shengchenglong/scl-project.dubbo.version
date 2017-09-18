//package com.scl.user.config;
//
//import java.sql.SQLException;
//
//import javax.sql.DataSource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.bind.RelaxedPropertyResolver;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//@Configuration
//public class DruidDataSourceConfig  implements EnvironmentAware {
//	
//	private Logger logger = LoggerFactory.getLogger(DruidDataSource.class);
//
//    private RelaxedPropertyResolver propertyResolver;
//
//    
//    @Override
//    public void setEnvironment(Environment env) {
//    	this.propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");
//    }
//
//    @Bean(name = "dataSource")
//    public DataSource dataSource() {
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(propertyResolver.getProperty("url"));
//        datasource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
//        datasource.setUsername(propertyResolver.getProperty("username"));
//        datasource.setPassword(propertyResolver.getProperty("password"));
//        datasource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("initial-size")));
//        datasource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("min-idle")));
//        datasource.setMaxWait(Long.valueOf(propertyResolver.getProperty("max-wait")));
//        datasource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("max-active")));
//        try {
//            datasource.setFilters("stat,wall");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        logger.info("--------------------------注入druidDatasource-----------------------------");
//        return datasource;
//    }
//    
//    
//}