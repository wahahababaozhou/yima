package com.jiema.repository.common;

import com.jiema.entity.common.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RoleRepository extends JpaRepository<Role, Long> {

    //根据节点层级获取响应节点
    List<Role> findAllByCode(String code);

}
