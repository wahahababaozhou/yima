package com.jiema.controller.form;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiema.entity.form.OrderManagement;
import com.jiema.manager.form.OrderManagementManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("orderManagement")
public class orderManagementController {

    private final OrderManagementManager orderManagementManager;

    @Autowired
    public orderManagementController(OrderManagementManager orderManagementManager) {
        this.orderManagementManager = orderManagementManager;
    }

    @GetMapping("openOrderManagement")
    public String openOrderManagement() {
        return "form/orderManagementList";
    }

    @GetMapping("openOrderManagementAdd")
    public String openOrderManagementAdd() {
        return "form/orderManagementAdd";
    }


    @PostMapping("getOrderManagementList")
    @ResponseBody
    public String getOrderManagementList(HttpServletRequest request) {
        String mobile = (String) request.getAttribute("mobile");


        List<OrderManagement> orderManagementList = orderManagementManager.findAllBySubmitterCode(mobile);
        JSONObject res = new JSONObject();
        res.put("code", 0);
        res.put("msg", "");
        res.put("count", orderManagementList.size());
        res.put("data", orderManagementList);
        return JSON.toJSONString(res);
    }

    @PostMapping("orderManagementAddOrUpdate")
    @ResponseBody
    public String orderManagementAddOrUpdate(OrderManagement orderManagement) {
        try {
            orderManagement.setCreateDate(new Date());
            orderManagement.setState("edit");
            orderManagementManager.saveOrderManagement(orderManagement);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "服务器处理数据异常！";
        }

    }

}
