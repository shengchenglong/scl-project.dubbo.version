package com.scl.cms.templateMethodModelEx;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.cms.service.ColumnService;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 *
 * 根据栏目code查询栏目，或者根据父栏目id查询栏目（联合查询出详情item）<br>
 * 参数:<br>
 *     columnCode: 要查询的栏目code（和parentCode同时仅能存在一个）<br>
 *     parentCode: 父栏目的code（和columnCode同时仅能存在一个）<br>
 *     siteCode:   站点code <br>
 *
 * Created by shengchenglong on 17/4/1.
 */
public class ListColumn implements TemplateMethodModelEx {

    @Reference(group = "cms")
    private ColumnService columnService;

    @Override
    public Object exec(List list) throws TemplateModelException {
        String columnCode = list.get(0).toString();
        String parentCode = list.get(1).toString();
        String siteCode = list.get(2).toString();

        if(!StringUtils.isEmpty(columnCode)) {
            return columnService.listWithColumnItemsByCode(columnCode, siteCode);
        }
        if(!StringUtils.isEmpty(parentCode)) {
            return columnService.listWithColumnItemsByParentCode(parentCode, siteCode);
        }

        return null;
    }
}
