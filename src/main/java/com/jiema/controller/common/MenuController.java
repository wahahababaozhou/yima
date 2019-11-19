package com.jiema.controller.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiema.entity.common.Menu;
import com.jiema.service.common.MenuManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController {


    private final MenuManager menuManager;

    @Autowired
    public MenuController(MenuManager menuManager) {
        this.menuManager = menuManager;
    }

    @ResponseBody
    @RequestMapping("/getMenuJson")
    public String getMenuJson() {
        System.out.println("getMenuJson");
        return menuManager.getAllMenuJson();
    }

    @GetMapping("/menu")
    public String menu() {
        return "common/menu/menuList";
    }

    @ResponseBody
    @RequestMapping("/getMenuList")
    public String getMenuList() {
        System.out.println("getMenuList");
        List<Menu> menuList = menuManager.getAllMenu();
        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", menuList.size());
        res.put("data", menuList);
        return JSON.toJSONString(res);

    }

    @GetMapping("/menuAdd")
    public String menuAdd() {
        return "common/menu/menuAdd";
    }

    @ResponseBody
    @PostMapping("/menuAddOrUpdate")
    public String menuAddOrUpdate(Menu menu) {
        return menuManager.saveMenu(menu);
    }

    @ResponseBody
    @RequestMapping("/menuDelete")
    public String menuDelete(Menu menu) {
        return menuManager.menuDelete(menuManager.findMenuByCode(menu.getCode()));
    }

    @ResponseBody
    @PostMapping("/menusDelete")
    public String menusDelete(String menuCodes) {
        List<String> menuCodeList = Arrays.asList(menuCodes.split(","));
        return menuManager.menusDelete(menuCodeList);
    }

}
