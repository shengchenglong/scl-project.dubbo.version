//package com.scl.config;
//
//import com.github.pagehelper.PageInterceptor;
//import org.apache.ibatis.plugin.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.DefaultResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
///**
// * Created by shengchenglong on 17/4/7.
// */
//@Configuration
//@EnableTransactionManagement
//public class MyBatisConfig implements TransactionManagementConfigurer {
//
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean(name = "sqlSessionFactory")
//    public SqlSessionFactory sqlSessionFactoryBean() {
//
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//
//        // 创建分页插件拦截器
//        PageInterceptor pageInterceptor = new PageInterceptor();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("autoRuntimeDialect", "true");
//        properties.setProperty("params", "count=countSql");
//        properties.setProperty("helperDialect", "mysql");
//        properties.setProperty("offsetAsPageNum", "true");
//        pageInterceptor.setProperties(properties);
//
//        // 添加分页插件拦截器
//        bean.setPlugins(new Interceptor[]{pageInterceptor});
//
//        bean.setDataSource(dataSource);
//        bean.setTypeAliasesPackage("com.scl.cms.domain");
//        bean.setMapperLocations(new Resource[]{new DefaultResourceLoader().getResource("classpath:com/scl/cms/mapper")});
//
//        try {
//            return bean.getObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//    @Bean
//    @Override
//    public PlatformTransactionManager annotationDrivenTransactionManager() {
//        return new DataSourceTransactionManager(dataSource);
//    }
//}
