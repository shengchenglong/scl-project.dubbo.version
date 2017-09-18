package com.scl.web.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.eum.EnumDelete;
import com.scl.eum.EnumStatus;
import com.scl.resultType.MsgBean;
import com.scl.user.domain.SysResource;
import com.scl.user.service.SysResourceService;
import com.scl.utils.UuidUtil;
import com.scl.web.utils.TreeDataUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 资源配置控制器
 * 
 * @author shengchenglong
 *
 */
@Controller
@RequestMapping("manage/resource")
public class SysResourceController {

	@Reference(group = "user")
	private SysResourceService resourceService;

	/**
	 * 资源首页跳转
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(Model model) {
		List<SysResource> resourceList = resourceService.getAll();
		resourceList = TreeDataUtil.buildTree(resourceList);
		model.addAttribute("resourceList", resourceList);
		return "user/resource/resource_index";
	}

	@RequestMapping("toCreate")
	public String toCreate(String parentCode, Model model) {
		SysResource parentResource = resourceService.selectByResourceCode(parentCode);
		model.addAttribute("parentResource", parentResource);
		return "user/resource/resource_edit";
	}

	@RequestMapping("toUpdate")
	public String toUpdate(String code, Model model) {
		// 先查出父节点
		SysResource resource = resourceService.selectByResourceCode(code);
		String parentCode = resource.getParentCode();
		if (!StringUtils.isEmpty(parentCode)) { // 若父节点不为空
			SysResource parentResource = resourceService.selectByResourceCode(parentCode);
			model.addAttribute("parentResource", parentResource);
		}
		model.addAttribute("resource", resource);
		return "user/resource/resource_edit";
	}
	
	@RequestMapping(value = "doEdit", method = RequestMethod.POST)
	@ResponseBody
	public MsgBean doEdit(SysResource resource) {
		// 资源新增
		if(StringUtils.isEmpty(resource.getId())) {
			resource.setCreateBy("admin");
			resource.setCreateTime(new Date());
			resource.setId(UuidUtil.generateID());
			resource.setIsDelete(EnumDelete.NO.getValue());
			// resource.setParentCodes(getParentCodes(resource.getParentCode()));
			resource.setStatus(EnumStatus.NORMAL.getValue());
			
			int res = resourceService.insert(resource);
			if(res == 1) {
				return new MsgBean(true);
			} else {
				return new MsgBean(false, null, null);
			}
		} else { // 资源修改
			
			return null;
		}
	}
	
	@RequestMapping(value="checkName", method=RequestMethod.POST)
	@ResponseBody
	public MsgBean checkName(String name, String id) {
		SysResource resource = resourceService.selectByResourceName(name);
		if(resource == null) {
			return new MsgBean(true);
		} else {
			if(!StringUtils.isEmpty(id) && id.equals(resource.getId())) {
				return new MsgBean(true);
			}
			return new MsgBean(false, "existed", null);
		}
	}
	
	@RequestMapping(value="checkCode", method=RequestMethod.POST)
	@ResponseBody
	public MsgBean checkCode(String code, String id) {
		SysResource resource = resourceService.selectByResourceCode(code);
		if(resource == null) {
			return new MsgBean(true);
		} else {
			if(!StringUtils.isEmpty(id) && id.equals(resource.getId())) {
				return new MsgBean(true);
			}
			return new MsgBean(false, "existed", null);
		}
	}
	
	@RequestMapping(value="checkPermission", method=RequestMethod.POST)
	@ResponseBody
	public MsgBean checkPermission(String permission, String id) {
		SysResource resource = resourceService.selectByResourcePermission(permission);
		if(resource == null) {
			return new MsgBean(true);
		} else {
			if(!StringUtils.isEmpty(id) && id.equals(resource.getId())) {
				return new MsgBean(true);
			}
			return new MsgBean(false, "existed", null);
		}
	}
	
	@RequestMapping(value="checkUrl", method=RequestMethod.POST)
	@ResponseBody
	public MsgBean checkUrl(String url, String id) {
		SysResource resource = resourceService.selectByResourceUrl(url);
		if(resource == null) {
			return new MsgBean(true);
		} else {
			if(!StringUtils.isEmpty(id) && id.equals(resource.getId())) {
				return new MsgBean(true);
			}
			return new MsgBean(false, "existed", null);
		}
	}
	
	/**
	 * 组装parentCodes
	 * @param parentCode
	 * @return
	 */
	private String getParentCodes(String parentCode) {
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		
		// 当有父code时
		while(!StringUtils.isEmpty(parentCode)) {
			SysResource resource = resourceService.selectByResourceCode(parentCode);
			if(resource != null) {
				list.add(resource.getCode());
				parentCode = resource.getParentCode();
			}
		}
		
		for(int i = list.size() - 1; i >= 0; i--) {
			sb.append(list.get(i));
			if(i != 0) {
				sb.append("/");
			}
		}
		
		// 若StringBuilder的值为空
		if(StringUtils.isEmpty(sb)) {
			return null;
		}
		
		return sb.toString();
			
	}

}
