package com.jiema.dao.jpa.form;

import com.jiema.entity.form.OrderManagement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderManagementRepository extends JpaRepository<OrderManagement, Long> {

    List<OrderManagement> findAllByCode(String code);

    List<OrderManagement> findAllByPublisherCode(String PublisherCode);

    List<OrderManagement> findAllBySubmitterCode(String submitterCode);

    List<OrderManagement> findAllById(Long id);
}
