package com.scl.web.utils;

import com.scl.user.domain.SysResource;

import java.util.ArrayList;
import java.util.List;



/**
 * 
 * @author shengchenglong
 *
 */
public class TreeDataUtil {
	private static List<SysResource> resultNodes = new ArrayList<SysResource>();// 树形结构排序之后的list内容
	private static List<SysResource> nodes; // 传入的无顺序的list参数

	/**
	 * 构建树形结构list
	 * 
	 * @return 返回树形结构List列表
	 */
	public static List<SysResource> buildTree(List<SysResource> list) {
        resultNodes.clear();
		nodes = list;
		for (SysResource node : nodes) {
			if (node.getCode().equals("root")) { // 先确定root节点
				resultNodes.add(node); // 添加一级节点
				build(node); // 递归获取二级、三级、。。。节点
			}
		}
		return resultNodes;
	}

	/**
	 * 递归循环子节点
	 * 
	 * @param node
	 *            当前节点
	 */
	private static void build(SysResource node) {
		List<SysResource> childrens = getChildrens(node);
		if (!childrens.isEmpty()) {// 如果存在子节点
			for (SysResource child : childrens) {// 将子节点遍历加入返回值中
				resultNodes.add(child);
				build(child);
			}
		}
	}

	/**
	 * @param node
	 * @return 返回
	 */
	private static List<SysResource> getChildrens(SysResource node) {
		List<SysResource> childrens = new ArrayList<SysResource>();
		for (SysResource child : nodes) {
			if (node.getCode().equals(child.getParentCode())) {// 如果code等于父code
				childrens.add(child);// 将该节点加入childrens list中
			}
		}
		return childrens;
	}

}