package com.jiema.service.form.impl;

import com.jiema.dao.mybatis.form.OrderManagementMapper;
import com.jiema.entity.form.OrderManagement;
import com.jiema.service.form.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuqi
 */
@Service("orderManagementService")
public class OrderManagementServiceImpl implements OrderManagementService {
    private final OrderManagementMapper orderManagement;

    @Autowired
    public OrderManagementServiceImpl(OrderManagementMapper orderManagement) {
        this.orderManagement = orderManagement;
    }

    public String query() {
        List<OrderManagement> a = orderManagement.finOrderManagementById(1l);
        return null;
    }
}
