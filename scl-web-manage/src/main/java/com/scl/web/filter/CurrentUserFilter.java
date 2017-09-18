//package com.scl.web.filter;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.web.filter.PathMatchingFilter;
//
//import com.alibaba.dubbo.config.annotation.Reference;
//import com.scl.user.service.SysUserService;
//
///**
// * 将user对象放入request中
// * @author shengchenglong
// *
// */
//public class CurrentUserFilter extends PathMatchingFilter {
//	
//	@Reference(group = "user")
//	private SysUserService userService;
//
//	@Override
//	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
//			throws Exception {
//		String username = (String) SecurityUtils.getSubject().getPrincipal();
//		request.setAttribute("currentUser", userService.selectByUsername(username));
//		return true;
//	}
//	
//	
//	
//
//}
