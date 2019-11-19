package com.jiema.controller.form;

import com.jiema.entity.form.Order;
import com.jiema.service.form.OrderManagementService;
import com.jiema.service.form.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author yuqi
 * 订单上报处理
 */
@Controller
@RequestMapping("order")
public class OrderController {

    private final OrderManagementService orderManagementService;
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderManagementService orderManagementService, OrderService orderService) {
        this.orderManagementService = orderManagementService;
        this.orderService = orderService;
    }

    @ResponseBody
    @PostMapping("/qrCode")
    public String qrCode(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        System.out.println(file.getName());
        return "";
    }

    @ResponseBody
    @PostMapping("/order")
    public String order(@RequestBody Order order) throws Exception {
        if (order != null) {
            if (order.getState() == null) {
                order.setState("0");
            }
            orderService.saveOrder(order);
            return null;
        } else {
            return "";
        }
    }

}
