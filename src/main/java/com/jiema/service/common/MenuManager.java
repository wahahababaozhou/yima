package com.jiema.service.common;

import com.jiema.entity.common.Menu;

import java.util.List;

public interface MenuManager {
    String getAllMenuJson();

    List<Menu> getAllMenu();

    String saveMenu(Menu menu);

    String menuDelete(Menu menu);

    String menusDelete(List<String> menuCodes);

    Menu findMenuByCode(String code);
}
