package com.scl.web.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.user.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("manage/user")
public class SysUserController {

	@Reference(group = "user")
	private SysUserService sysUserService;
	
	@RequestMapping("/getUser")
	public String userDemo() {
		return "";
	}

}
