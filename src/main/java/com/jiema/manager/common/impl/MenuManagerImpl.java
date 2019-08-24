package com.jiema.manager.common.impl;

import com.alibaba.fastjson.JSON;
import com.jiema.entity.common.Menu;
import com.jiema.manager.common.MenuManager;
import com.jiema.repository.common.MenuRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuManagerImpl implements MenuManager {

    private final MenuRepository menuRepository;
    private final Logger logger = LoggerFactory.getLogger(MenuManagerImpl.class);

    @Autowired
    public MenuManagerImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public String getAllMenuJson() {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Menu> menu0List = menuRepository.findAllByLevel("0");
        menu0List.forEach(menu0 -> {
            List<Menu> menu1List = menuRepository.findByParentCode(menu0.getCode());
            List<Map<String, Object>> menu1ListMap = new ArrayList<Map<String, Object>>();
            menu1List.forEach(menu1 -> {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("title", menu1.getName());
                map.put("icon", menu1.getIcon());
                map.put("href", menu1.getUrl());
                map.put("spread", menu1.getSpread());
                if (!StringUtils.isEmpty(menu1.getTarget())) {
                    map.put("target", menu1.getTarget());
                }
                List<Menu> menu2List = menuRepository.findByParentCode(menu1.getCode());
                if (menu2List.size() != 0) {
                    List<Map<String, Object>> menu2ListMap = new ArrayList<Map<String, Object>>();
                    menu2List.forEach(meun2 -> {
                        Map<String, Object> map2 = new HashMap<String, Object>();
                        map2.put("title", meun2.getName());
                        map2.put("icon", meun2.getIcon());
                        map2.put("href", meun2.getUrl());
                        map2.put("spread", meun2.getSpread());
                        if (!StringUtils.isEmpty(meun2.getTarget())) {
                            map2.put("target", meun2.getTarget());
                        }
                        menu2ListMap.add(map2);
                    });
                    map.put("children", menu2ListMap);
                }
                menu1ListMap.add(map);
            });
            resultMap.put(menu0.getCode(), menu1ListMap);
        });
        System.out.println(JSON.toJSONString(resultMap));
        return JSON.toJSONString(resultMap);
    }

    public List<Menu> getAllMenu() {
        return menuRepository.findAll();
    }

    public String saveMenu(Menu menu) {
        try {
            menuRepository.save(menu);
            logger.info(menu.toString(), "保存成功");
            return "success";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "erro";
        }
    }

    public String menuDelete(Menu menu) {
        try {
            menuRepository.delete(menu);
            logger.info(menu.toString(), "删除成功");
            return "success";
        } catch (Exception e) {
            logger.error(e.getMessage());
            return "erro";
        }
    }

    public Menu findMenuByCode(String code) {
        List<Menu> menuList = menuRepository.findByCode(code);
        if (menuList.size() > 0) {
            return menuList.get(0);
        } else {
            return null;
        }
    }

    public String menusDelete(List<String> menuCodes) {
        menuCodes.forEach(menuCode -> menuDelete(findMenuByCode(menuCode)));
        return "success";
    }


}
