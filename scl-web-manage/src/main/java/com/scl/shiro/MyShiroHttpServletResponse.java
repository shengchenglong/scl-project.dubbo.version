//package com.scl.shiro;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
//import org.apache.shiro.web.servlet.ShiroHttpServletResponse;
//
///**
// * 为了取出shiro 中地址后面跟上 sessionid 的处理
//	 在1.3.2 以上的版本中  已经修复了这个bug，在sessionManage中设置
// * @author shengchenglong
// *
// */
//public class MyShiroHttpServletResponse extends ShiroHttpServletResponse {
//
//	public MyShiroHttpServletResponse(HttpServletResponse wrapped, ServletContext context,
//			ShiroHttpServletRequest request) {
//		super(wrapped, context, request);
//	}
//
//	@Override
//	protected String toEncoded(String url, String sessionId) {
//		return url;
//	}
//
//}
