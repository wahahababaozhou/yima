package com.jiema.service.common;

import com.jiema.entity.common.User;

import java.util.List;

public interface UserManager {
    User getUserByMobile(String mobile);

    List<User> getAllUser();

    String deleteUserByIds(List<Long> ids);

    String deleteUserById(Long id);

    List<User> getUserListByCode(String code);

    List<User> getUserListByMobile(String mobile);

    List<User> getUserListByEmail(String email);

    String saveUser(User user);
}
