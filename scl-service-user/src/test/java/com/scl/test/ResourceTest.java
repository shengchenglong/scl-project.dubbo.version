package com.scl.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scl.ApplicationBootStrap;
import com.scl.user.domain.SysUser;
import com.scl.user.service.SysOrganizationService;
import com.scl.user.service.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(properties = {"application.properties"}, classes = ApplicationBootStrap.class)
// 其实这里默认就是application.properties
public class ResourceTest {

	@Autowired
	private SysOrganizationService organizationService;
//	
//	@Test
//	public void test1() {
//		SysResource resource = resourceService.selectByResourceCode("resourceView");
//		System.out.println(resource.toString());
//		
//	}
//	
	
	@Resource
	private SysUserService userService;
	
	@Test
	public void test1() {
		SysUser user = userService.selectByUsername("scl");
		System.out.println(user.toString());
		
		System.out.println(organizationService.selectByPrimaryKey("aaa"));
	}
	
}