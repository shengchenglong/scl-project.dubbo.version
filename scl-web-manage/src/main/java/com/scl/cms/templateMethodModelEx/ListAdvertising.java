package com.scl.cms.templateMethodModelEx;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.cms.service.AdvertisingService;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by shengchenglong on 17/4/6.
 */
public class ListAdvertising implements TemplateMethodModelEx {

    @Reference(group = "cms")
    private AdvertisingService advertisingService;

    @Override
    public Object exec(List list) throws TemplateModelException {
        String siteCode = list.get(0).toString();
        String columnCode = list.get(1).toString();

        if (!StringUtils.isEmpty(siteCode) && !StringUtils.isEmpty(columnCode)) {
            return advertisingService.listBySiteCodeAndColumnCode(siteCode, columnCode);
        }

        return null;
    }
}
