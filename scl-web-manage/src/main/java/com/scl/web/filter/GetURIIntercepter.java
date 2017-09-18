package com.scl.web.filter;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class GetURIIntercepter implements HandlerInterceptor {
	
	/** 
     * 在请求处理之前执行，该方法主要是用于准备资源数据的，然后可以把它们当做请求属性放到WebRequest中 
     */ 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Long beginTime = System.currentTimeMillis();
		request.setAttribute("beginTime", beginTime);
		return true;
	}

	/** 
     * 该方法将在Controller执行之后，返回视图之前执行，ModelMap表示请求Controller处理之后返回的Model对象，所以可以在 
     * 这个方法中修改ModelMap的属性，从而达到改变返回的模型的效果。
     * 
     *  这里如果是post请求 ，则会null  modelAndView
     */  
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		Long endTime = System.currentTimeMillis();
		Long beginTime = (Long) request.getAttribute("beginTime");
		Long time = endTime - beginTime;
		
		String uri = request.getServletPath();
		if(modelAndView != null) {
			String[] strs = uri.split("/");
			StringBuilder sb = new StringBuilder();
			for(int i = 1; i < strs.length - 1; i++) {
				sb.append("/" + strs[i]);
			}
			sb.append("/index");
			uri = sb.toString();
			modelAndView.addObject("uri", uri);
		}
		
		System.out.println("本次请求" + "[" + new Date(System.currentTimeMillis()).toString() + "]" + "：" + uri + "(" + time + "ms)");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
