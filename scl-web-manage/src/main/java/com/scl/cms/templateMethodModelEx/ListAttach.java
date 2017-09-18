package com.scl.cms.templateMethodModelEx;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.cms.service.AttachService;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 根据hostId来查询附件 <br>
 * 参数： <br>
 *     hostId: 所属项目的id
 *
 * Created by shengchenglong on 17/4/6.
 */
public class ListAttach implements TemplateMethodModelEx {

    @Reference(group = "cms")
    private AttachService attachService;

    @Override
    public Object exec(List list) throws TemplateModelException {
        String hostId = list.get(0).toString();

        if(!StringUtils.isEmpty(hostId)) {
            return attachService.listByHostId(hostId);
        }

        return null;
    }
}
