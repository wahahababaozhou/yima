package com.jiema.controller.common;

import com.jiema.entity.common.User;
import com.jiema.manager.common.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class CenterController {

    private final UserManager userManager;

    @Autowired
    public CenterController(UserManager userManager) {
        this.userManager = userManager;
    }

    /**
     * 登录页面
     */
    @GetMapping("/login")
    public String login() {
        return "common/login/login";
    }

    /**
     * 注册页面
     */
    @RequestMapping("/register")
    public String register() {
        return "common/register/register";
    }


    /**
     * 登录
     */
    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpServletRequest request) {
        try {
            User user = userManager.getUserByMobile(username);
            if (user == null) {
                map.put("message", username + "用户不存在");
                return "common/login/login";
            } else if (password.equals(user.getPassword())) {
                request.getSession().setAttribute("user", user.getMobile());
                map.put("message", "success");
                return "home";
            } else {
                map.put("username", "登录失败");
                return "common/login/login";
            }
        } catch (Exception e) {
            return "common/login/login";
        }

    }

    /**
     * 注销登录
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }


}
