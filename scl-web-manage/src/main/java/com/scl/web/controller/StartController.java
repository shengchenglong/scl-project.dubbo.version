package com.scl.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.scl.user.service.SysMenuService;
import com.scl.user.service.SysResourceService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.eum.EnumDelete;
import com.scl.eum.EnumLock;
import com.scl.resultType.MsgBean;
import com.scl.user.domain.SysUser;
import com.scl.user.service.SysUserService;
import com.scl.utils.UuidUtil;

/**
 * 登陆注册控制器
 * 
 * @author shengchenglong
 *
 */
@Controller
@RequestMapping("manage")
public class StartController {

	private Logger logger = LoggerFactory.getLogger(StartController.class);

	@Reference(group = "user")
	private SysUserService sysUserService;

	@Reference(group = "user")
	private SysResourceService sysResourceService;

	@Reference(group = "user")
	private SysMenuService sysMenuService;

	/**
	 * 登陆
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request, Model model) {
		
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		String errorCode = null;

		if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
			errorCode = "unknowAccount";
		} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
			errorCode = "wrongPassword";
		} else if (LockedAccountException.class.getName().equals(exceptionClassName)) {
			errorCode = "lockedAccount";
		} else if (exceptionClassName != null) {
			errorCode = "otherException：" + exceptionClassName;
		}
		model.addAttribute("errorCode", errorCode);
		
		logger.info("login failue： " + exceptionClassName);
		return "login";

	}
	
	@RequestMapping("index")
	public String index() {
		return "index";
	}

//	/**
//	 * 注册页面跳转
//	 * @return
//	 */
//	@RequestMapping(value = "start/toRegist", method = RequestMethod.GET)
//	public String toRegist() {
//		return "sign/signUp";
//	}

	/**
	 * 注册动作
	 * @return
	 */
	@RequestMapping(value = "start/doRegist", method = RequestMethod.POST)
	@ResponseBody
	public MsgBean doRegist(SysUser user) {
		user.setCreateTime(new Date());
		user.setId(UuidUtil.generateID());
		user.setIsLocked(EnumLock.NO.getValue());
		// 加盐密码
		String salt1 = user.getUsername();
		String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex(); 
		SimpleHash hash = new SimpleHash("md5", user.getPassword(), salt1 + salt2, 2);
		user.setPassword(hash.toHex()); // 这里的密码入库时存储的是MD5(MD5(username+password+salt))
		user.setSalt(salt2);			// salt 存储那个随机码
		user.setIsDelete(EnumDelete.NO.getValue());
		int res = sysUserService.insert(user);
		if(res == 1) {
			return new MsgBean(true); 
		} else {
			return new MsgBean(false);
		}
	}
	
	/**
	 * 验证 用户名
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "start/checkUsername", method = RequestMethod.POST)
	@ResponseBody
	public MsgBean checkUsername(String username) {
		// 判断是否 已经存在
		SysUser existUser = sysUserService.selectByUsername(username);
		if(existUser != null) {
			return new MsgBean(false, "exist", null);
		}
		return new MsgBean(true);
	}

//	@RequestMapping(value = "start/getMenus", method = RequestMethod.POST)
//	@ResponseBody
//	public MsgBean getMenus() {
//		Subject subject = SecurityUtils.getSubject();
//		if (subject.isAuthenticated()) {
//			List<SysResource> allResources = sysResourceService.getAll();
//			List<SysMenu> menus = new ArrayList<>();
//			for(SysResource resource : allResources) {
//				if (subject.isPermitted(resource.getPermission())) {
//					menus.add(sysMenuService.selectByPrimaryKey());
//				}
//			}
//			return new MsgBean();
//		}
//	}

}
