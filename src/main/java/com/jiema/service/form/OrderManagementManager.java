package com.jiema.service.form;

import com.jiema.entity.form.OrderManagement;

import java.util.List;

public interface OrderManagementManager {

    List<OrderManagement> findAllByPublisherCode(String PublisherCode);

    List<OrderManagement> findAllBySubmitterCode(String submitterCode);

    String saveOrderManagement(OrderManagement orderManagement);

    List<OrderManagement> findAllById(Long id);
}
