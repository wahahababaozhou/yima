package com.jiema.service.form.impl;

import com.jiema.dao.jpa.form.OrderRepository;
import com.jiema.dao.mybatis.form.OrderMapper;
import com.jiema.entity.form.Order;
import com.jiema.service.form.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuqi
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    public List<Order> finOrderByFarmerIdAndBuyTime(String farmer_id, String buy_time) {
        return orderMapper.finOrderByIdAndBuyTime(farmer_id, buy_time);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
