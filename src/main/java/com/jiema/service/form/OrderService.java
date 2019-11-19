package com.jiema.service.form;

import com.jiema.entity.form.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuqi
 * 订单处理接口
 */
public interface OrderService {
    /**
     * 根据用户ID和 起始时间查询所有订单
     */
    List<Order> finOrderByFarmerIdAndBuyTime(String farmer_id, String buy_time);

    /**
     * 保存订单
     */
    void saveOrder(Order order);
}
