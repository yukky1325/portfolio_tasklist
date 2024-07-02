package com.todojava.tasklist.main.service;

import com.todojava.tasklist.main.dao.UserMapper;
import com.todojava.tasklist.main.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }
}
