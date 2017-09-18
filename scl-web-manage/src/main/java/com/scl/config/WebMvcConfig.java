package com.scl.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.scl.web.filter.GetURIIntercepter;
import com.scl.web.filter.WebMvcSiteMeshFilter;

/**
 * Spring Mvc 相关配置
 * @author shengchenglong
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * 添加拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new GetURIIntercepter()).addPathPatterns("/**").excludePathPatterns("/static/**", "/**/doEdit");
	}

	/**
	 * 映射静态资源文件
	 * 
	 * tips: "/" is required for the String params
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/static/");
	}
	
	
	/**
	 * 声明SiteMesh 过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebMvcSiteMeshFilter());
		return filterRegistrationBean;
	}

//	@Bean
//	public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}

}
