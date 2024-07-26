package com.todojava.tasklist.main.service;

import com.todojava.tasklist.main.dao.UserMapper;
import com.todojava.tasklist.main.entity.RecordTaskItem;
import com.todojava.tasklist.main.entity.UserDetails;
import com.todojava.tasklist.main.entity.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {

        this.userMapper = userMapper;
    }

    public List<UserDetails> findByuser() {

        return userMapper.findAll();
    }

    public List<RecordTaskItem> findByRecordTask() {

        return userMapper.findAllRecordTask();
    }

    public UserDetails findByUser(String loggedInUser) {
        Optional<UserDetails> findByUserInfo = userMapper.findUserInfo(loggedInUser);
        if (findByUserInfo.isPresent()) {
            UserDetails user = findByUserInfo.get();
            return user;
        } else {
            throw new UserNotFoundException("User Not Found");

        }

    }
}
