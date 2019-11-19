package com.jiema.service.form.impl;

import com.jiema.dao.jpa.form.OrderManagementRepository;
import com.jiema.entity.form.OrderManagement;
import com.jiema.service.form.OrderManagementManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderManagementManagerImpl implements OrderManagementManager {

    private final OrderManagementRepository orderManagementRepository;

    @Autowired
    public OrderManagementManagerImpl(OrderManagementRepository orderManagementRepository) {
        this.orderManagementRepository = orderManagementRepository;
    }

    public List<OrderManagement> findAllByPublisherCode(String PublisherCode) {
        return orderManagementRepository.findAllByPublisherCode(PublisherCode);
    }

    public List<OrderManagement> findAllBySubmitterCode(String submitterCode) {
        return orderManagementRepository.findAllBySubmitterCode(submitterCode);
    }

    public String saveOrderManagement(OrderManagement orderManagement) {
        try {
            orderManagementRepository.saveAndFlush(orderManagement);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

    public List<OrderManagement> findAllById(Long id) {
        return orderManagementRepository.findAllById(id);
    }

}
