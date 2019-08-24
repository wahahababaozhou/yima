package com.jiema.repository.common;

import com.jiema.entity.common.User;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByCode(String code);

    List<User> findByMobile(String code);

    List<User> findByEmail(String email);
}
