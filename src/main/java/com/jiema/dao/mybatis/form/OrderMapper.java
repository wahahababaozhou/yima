package com.jiema.dao.mybatis.form;

import com.jiema.entity.form.Order;
import com.jiema.entity.form.OrderManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yuqi
 */
@Mapper
@Service
public interface OrderMapper {
    @Select("select * from farmer_order where farmer_id = #{farmer_id} and buy_time >=#{buy_time}")
    List<Order> finOrderByIdAndBuyTime(@Param("farmer_id") String farmer_id, @Param("buy_time") String buy_time);
}
