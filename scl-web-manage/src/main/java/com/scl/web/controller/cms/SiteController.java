package com.scl.web.controller.cms;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.cms.domain.Dictionary;
import com.scl.cms.domain.Site;
import com.scl.cms.service.DictionaryService;
import com.scl.cms.service.SiteService;
import com.scl.eum.EnumDelete;
import com.scl.eum.RedisKey;
import com.scl.eum.SystemDictionary;
import com.scl.resultType.MsgBean;
import com.scl.utils.SerializeUtil;
import com.scl.utils.UuidUtil;
import com.scl.utils.BeanUtils;
import org.apache.curator.SessionFailRetryLoop;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 站点Controller
 * Created by shengchenglong on 17/3/3.
 */
@Controller
@RequestMapping("manage/site")
public class SiteController {

    @Reference(group = "cms")
    private SiteService siteService;
    @Reference(group = "cms")
    private DictionaryService dictionaryService;

    @Resource
    private RedisManager redisManager;

    /**
     * 跳转到管理页面
     * @return
     */
    @RequestMapping("index")
    public String index(Model model) {
        List<Site> list = siteService.getAllParentSiteWithChildrenSite();
        List<Dictionary> languages = getLanguageFromRedis();

        // 组装显示的语言版本
        StringBuilder sb = new StringBuilder("");
        for (Site parentSite : list) {
            for(Site childSite : parentSite.getChildSites()) {
                for(Dictionary dict : languages) {
                    if(dict.getCode().equals(childSite.getLanguageCode())) {
                        if("".equals(sb.toString())) {
                            sb.append(dict.getValue());
                        } else {
                            sb.append("｜" + dict.getValue());
                        }
                    }
                }
            }
            parentSite.setLanguageVersion(sb.toString());
            sb = new StringBuilder("");
        }

        model.addAttribute("siteList", list);
        return "cms/site/site_index";
    }

    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping("toCreate")
    public String toCreate(Model model) {
        List<Dictionary> languages = getLanguageFromRedis();
        model.addAttribute("languagesDict", languages);
        return "cms/site/site_edit";
    }

    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping("toUpdate")
    public String toUpdate(String siteId, Model model) {
        Site site = siteService.selectByPrimaryKey(siteId);
        List<Dictionary> languages = getLanguageFromRedis();
        model.addAttribute("site", site);
        model.addAttribute("languagesDict", languages);
        return "cms/site/site_edit";
    }

    /**
     * 编辑结果返回
     * @return
     */
    @RequestMapping(value = "doEdit", method = RequestMethod.POST)
    @ResponseBody
    public MsgBean doEdit(Site temp) {
        List<Site> sites = getSiteList(temp);
        if(sites != null && sites.size() > 0) {
            int num = 0;

            if(StringUtils.isEmpty(temp.getId())) { // 新增站点
                num = siteService.insertBatch(sites);
            } else { // 修改站点(先删除，再添加)
                num = siteService.updateBatchByIdSelective(sites, temp.getId());
            }

            if(num == sites.size()) {
                return new MsgBean(true);
            }
        }
        return new MsgBean(false);
    }

    @RequestMapping("deleteBatch")
    @ResponseBody
    public MsgBean deleteBatch(String idsString) {
        String[] idArray = idsString.split(",");
        int num = siteService.deleteBatchById(Arrays.asList(idArray));
        if(num > 0) {
            return new MsgBean(true);
        }
        return new MsgBean(false);
    }


    /**
     * 封装公用方法：从前台传过来站点数据后，解析获取将要添加或修改的站点集合
     *
     * @param site
     * @return
     */
    private List<Site> getSiteList(Site site) {
        site.setWhetherDelete(EnumDelete.NO.getValue());
        List<Site> sites = new ArrayList<Site>();

        // 1.新建父站点
        Site parentSite = new Site();
        Date date = new Date();

        BeanUtils.copyProperties(site, parentSite);
        parentSite.setId(UuidUtil.generateID());
        parentSite.setCreateTime(date);
        sites.add(parentSite);

        // 2.循环语言版本，新建子站点
        String[] languages = site.getLanguageCode().split(",");

        for(int i = 1; i <= languages.length; i ++) {
            Site childSite = new Site();
            BeanUtils.copyProperties(parentSite, childSite);
            childSite.setId(UuidUtil.generateID());
            childSite.setLanguageCode(languages[i - 1]);
            childSite.setSort(i);
            childSite.setCode(parentSite.getCode() + "_" + languages[i - 1]);
            childSite.setParentId(parentSite.getId());
            sites.add(childSite);
        }

        return  sites;
    }

    /**
     * 从redis中获取语言版本对象集合
     * @return
     */
    private List<Dictionary> getLanguageFromRedis() {
        byte[] bytes = redisManager.get(RedisKey.LANGUAGE_CODE_ALL.toString().getBytes());
        List<Dictionary> languages = (List<Dictionary>) SerializeUtil.unserialize(bytes);
        return languages;
    }


}
