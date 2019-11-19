package com.jiema.controller.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiema.entity.common.User;
import com.jiema.service.common.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserManager userManager;

    @Autowired
    public UserController(UserManager userManager) {
        this.userManager = userManager;
    }

    @GetMapping("/userList")
    public String userList() {
        return "common/user/userList";
    }


    @PostMapping("/getUserList")
    @ResponseBody
    public String getUserList() {
        List<User> userList = userManager.getAllUser();
        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", userList.size());
        res.put("data", userList);
        return JSON.toJSONString(res);
    }

    /**
     * 删除用户
     */
    @PostMapping("/deleteUserList")
    @ResponseBody
    public String deleteUserList(@RequestParam("userIDs") List<Long> userIDs) {
        return JSON.toJSONString(userManager.deleteUserByIds(userIDs));
    }


    /**
     * 注册
     */
    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam("mobile") String mobile,
                           @RequestParam("name") String name,
                           @RequestParam("password") String password,
                           @RequestParam("email") String email) {
        if (userManager.getUserListByMobile(mobile).size() > 0) {
            return "该手机号已注册，请直接登录";
        } else if (userManager.getUserListByEmail(email).size() > 0) {
            return "该邮箱已注册，请直接登录";
        } else {
            User user = new User();
            user.setCode(mobile);
            user.setMobile(mobile);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setCreateDate(new Date());
            if ("success".equals(userManager.saveUser(user))) {
                return "注册成功";
            } else {
                return "注册失败！请联系管理员！";
            }
        }
    }


}
