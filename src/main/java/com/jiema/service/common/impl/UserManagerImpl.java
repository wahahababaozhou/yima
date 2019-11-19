package com.jiema.service.common.impl;

import com.jiema.entity.common.User;
import com.jiema.dao.jpa.common.UserRepository;
import com.jiema.service.common.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserManagerImpl implements UserManager {

    private final UserRepository userRepository;

    @Autowired
    public UserManagerImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByMobile(String mobile) {

        if (userRepository.findByCode(mobile).size() == 0) {
            return null;
        }
        return userRepository.findByCode(mobile).get(0);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public String deleteUserByIds(List<Long> ids) {
        try {
            ids.forEach(id -> userRepository.deleteById(id));
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String deleteUserById(Long id) {
        try {
            userRepository.deleteById(id);
            return "success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<User> getUserListByCode(String code) {
        return userRepository.findByCode(code);
    }

    public List<User> getUserListByMobile(String mobile) {
        return userRepository.findByCode(mobile);
    }

    public List<User> getUserListByEmail(String email) {
        return userRepository.findByCode(email);
    }

    public String saveUser(User user) {
        try {
            if (getUserListByCode(user.getCode()).size() > 0) {
                return "用户编号重复";
            } else {
                userRepository.save(user);
                return "success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        }
    }
}
