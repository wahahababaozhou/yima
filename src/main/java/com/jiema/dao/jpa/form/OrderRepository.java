package com.jiema.dao.jpa.form;

import com.jiema.entity.form.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yuqi
 */

public interface OrderRepository extends JpaRepository<Order, Long> {
}
