package com.scl.web.controller.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scl.resultType.MsgBean;
import com.scl.user.domain.SysMenu;
import com.scl.user.service.SysMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by shengchenglong on 17/2/21.
 */
@Controller
@RequestMapping("manage/menu")
public class SysMenuController {

    @Reference(group = "user")
    private SysMenuService sysMenuService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {

        return "menu/menu_index";

    }

    @RequestMapping(value = "getMenus", method = RequestMethod.POST)
    @ResponseBody
    public MsgBean getMenus() {
        List<SysMenu> menus = sysMenuService.getAll();
        return new MsgBean(true, null, menus);
    }
}
