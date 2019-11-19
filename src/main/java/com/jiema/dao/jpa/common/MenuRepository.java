package com.jiema.dao.jpa.common;

import com.jiema.entity.common.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MenuRepository extends JpaRepository<Menu, Long> {

    //根据节点层级获取响应节点
    List<Menu> findAllByLevel(String level);

    List<Menu> findByCode(String code);

    List<Menu> findByParentCode(String code);
}
