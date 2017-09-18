package com.scl.web.controller.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import com.scl.cms.domain.Dictionary;
import com.scl.cms.service.DictionaryService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shengchenglong on 17/4/13.
 */
@Controller
@RequestMapping("manage/dictionary")
public class DictionaryController {

    @Reference(group = "cms")
    private DictionaryService dictionaryService;

    @RequestMapping("index")
    public String index(PageInfo<Dictionary> pageInfo, String parentId, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(!StringUtils.isEmpty(parentId)) {
            map.put("parentId", parentId);
        }
        pageInfo = dictionaryService.listPage(pageInfo, map);

        model.addAttribute("page", pageInfo);
        return "cms/dictionary/dictionary_index";
    }



}
