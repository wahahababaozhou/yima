package com.jiema.controller.common;

import com.jiema.entity.common.User;
import com.jiema.service.common.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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

    private static class Login {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public String login(/*@RequestParam("username") String username,
                        @RequestParam("password") String password,*/
            @RequestBody Login login,
            HttpSession session) {
        Map<String, String> map = new HashMap<>();
        try {
            User user = userManager.getUserByMobile(login.getUsername());
            if (user == null) {
                map.put("message", login.getUsername() + "用户不存在");
                return "common/login/login";
            } else if (login.getPassword().equals(user.getPassword())) {
                session.setAttribute("user", user.getMobile());
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
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "common/login/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }


}
