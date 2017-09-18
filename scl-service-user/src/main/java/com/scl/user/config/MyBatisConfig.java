//package com.scl.user.config;
//
//import java.util.Properties;
//
//import javax.sql.DataSource;
//
//import org.aopalliance.intercept.Interceptor;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.core.io.support.ResourcePatternResolver;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import com.github.pagehelper.PageHelper;
//
//@Configuration
//@EnableTransactionManagement
//public class MyBatisConfig implements TransactionManagementConfigurer {
//
//	@Autowired
//	private DataSource dataSource;
//
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() {
//		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//		bean.setDataSource(dataSource);
//		bean.setTypeAliasesPackage("com.scl.user.domain");
//		
////		PageHelper pageHelper = new PageHelper();
////        Properties properties = new Properties();
////        properties.setProperty("reasonable", "true");
////        properties.setProperty("supportMethodsArguments", "true");
////        properties.setProperty("returnPageInfo", "check");
////        properties.setProperty("params", "count=countSql");
////        pageHelper.setProperties(properties);
////
////        //添加插件
////        bean.setPlugins(new Interceptor[]{pageHelper});
//        
//		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		try {
//			bean.setMapperLocations(resolver.getResources("classpath:com/scl/user/mapper/*.xml"));
//			return bean.getObject();
//		} catch (Exception e) {
//			e.printStackTrace();
//			// throw new RuntimeException(e);
//			return null;
//		}
//	}
//
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//		return new SqlSessionTemplate(sqlSessionFactory);
//	}
//	
//	@Override
//	public PlatformTransactionManager annotationDrivenTransactionManager() {
//		return new DataSourceTransactionManager(dataSource);
//	}
//
//}
