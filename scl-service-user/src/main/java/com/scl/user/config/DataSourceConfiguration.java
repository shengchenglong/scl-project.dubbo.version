//package com.scl.user.config;
//
//import javax.sql.DataSource;
//
//import org.apache.commons.dbcp2.BasicDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//
//import com.alibaba.druid.pool.DruidDataSource;
//
//@Configuration
//@PropertySource("classpath:dataSource.properties")
//public class DataSourceConfiguration {
//
//	@Value("${jdbc.driver}")
//	private String driver;
//
//	@Value("${jdbc.url}")
//	private String url;
//
//	@Value("${jdbc.username}")
//	private String username;
//
//	@Value("${jdbc.password}")
//	private String password;
//
//	@Value("${jdbc.maxTotal}")
//	private int maxTotal;
//
//	@Value("${jdbc.maxIdel}")
//	private int maxIdel;
//
//	@Value("${jdbc.maxWait}")
//	private long maxWait;
//
//	public DataSource dataSource() {
//		DruidDataSource dataSource = new DruidDataSource();
//		dataSource.
//	}
//	
//}
