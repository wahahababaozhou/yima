package com.jiema.dao.mybatis.form;

import com.jiema.entity.form.OrderManagement;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuqi
 */
@Mapper
@Service
public interface OrderManagementMapper {

    @Select("select * from order_management where id = #{id}")
    List<OrderManagement> finOrderManagementById(@Param("id") Long id);
}
