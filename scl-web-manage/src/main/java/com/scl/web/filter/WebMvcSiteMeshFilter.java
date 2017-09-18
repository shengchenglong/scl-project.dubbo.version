package com.scl.web.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * SiteMesh 路径配置过滤器
 * @author shengchenglong
 *
 */
public class WebMvcSiteMeshFilter extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/manage/*", "/WEB-INF/jsp/decrators/decorator.jsp");
		builder.addExcludedPath("/manage/login");
//				.addExcludedPath("/**/toUpdate")
//				.addExcludedPath("/**/toCreate")
//				.addExcludedPath("/**/toRegist");
	}

}

