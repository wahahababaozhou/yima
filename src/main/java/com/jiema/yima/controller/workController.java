package com.jiema.yima.controller;

import com.jiema.manager.common.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class workController {
    @Autowired
    private UserManager userManager;

  /*  @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "你好");
        return "success";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map) {
        User user = userManager.getUserByMobile(username);

        if (password.equals(user.getPassword())) {
            map.put("username", user.getName());
            return "index";
        } else {
            map.put("username", "登录失败");
            return "success";
        }
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "login";
    }*/
   /* @RequestMapping("/login")
    public String login() {
        return "login";
    }*/

}
