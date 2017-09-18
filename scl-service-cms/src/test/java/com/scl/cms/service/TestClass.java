package com.scl.cms.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.remoting.transport.grizzly.GrizzlyClient;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scl.ApplicationBootStrap;
import com.scl.cms.domain.*;
import com.scl.cms.mapper.AdvertisingMapper;
import com.scl.cms.mapper.DictionaryMapper;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.ObjectContent;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shengchenglong on 17/3/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = {ApplicationBootStrap.class})
@SpringBootTest(classes = {ApplicationBootStrap.class})
public class TestClass {


    @Reference(group = "cms")
    private SiteService siteService;

    @Resource
    private DictionaryMapper dictionaryMapper;


    @Resource
    private AdvertisingMapper advertisingMapper;

    @Reference(group = "cms")
    private TemplateService templateService;

    @Test
    public void test1() {
        System.out.println(siteService.getAllParentSiteWithChildrenSite());
        for(Site site : siteService.getAllParentSiteWithChildrenSite()) {
            List children = site.getChildSites();
            System.out.println(children.size());
        }
    }


    @Test
    public void test2() {
        AdvertisingExample example = new AdvertisingExample();

        // 只写这一条时，WHERE ( tb.publish_status = 1 and tb.id = "aaa" )
        example.or().andPublishStatusEqualTo(1).andIdEqualTo("aaa");

        // 加上这一条时，WHERE ( tb.publish_status = 1 and tb.id = "aaa" ) or( tb.id = "bbb" and tb.publish_status = 1 )
        example.or().andIdEqualTo("bbb").andPublishStatusEqualTo(1);

        List<Advertising> advertisings = advertisingMapper.selectByExample(example);
        for(Advertising ad : advertisings) {
            System.out.println(ad.toString());
        }
    }

    @Test
    public void test3() {
        PageInfo<Template> pageInfo = new PageInfo<Template>();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(1);

        Map<String, Object> map = new HashMap<>();
        map.put("siteId", "b");
        PageInfo<Template> results = templateService.listPage(pageInfo, map);

        List<Template> list = results.getList();
        for(Template t : list) {
            System.out.println(t.toString());
        }
    }

    @Test
    public void test4() {
        Dictionary dictionary = dictionaryMapper.getByCodeWithChildren("language");
        System.out.println(dictionary.toString());
    }


}
