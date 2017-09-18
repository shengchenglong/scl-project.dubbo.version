package com.scl.cms.templateMethodModelEx;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.cms.service.SiteService;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

import java.util.List;

/**
 * Created by shengchenglong on 17/3/17.
 */
public class ListSite implements TemplateMethodModelEx {

    @Reference(group = "cms")
    private SiteService siteService;

    @Override
    public Object exec(List list) throws TemplateModelException {
        String siteCode = list.get(0).toString();
        String language = list.get(1).toString();


        return null;
    }

}
