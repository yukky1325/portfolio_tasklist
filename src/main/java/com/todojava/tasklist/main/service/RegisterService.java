package com.todojava.tasklist.main.service;

import com.todojava.tasklist.main.dao.UserMapper;
import com.todojava.tasklist.main.entity.RegisterUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public String insertUser(RegisterUser registerUser) {
        Optional<RegisterUser> optionalUser = userMapper.findByUser(registerUser.getUsername(), registerUser.getEmail());
        if (optionalUser.isPresent()) {
            return "ユーザが重複しています";
        } else {
            String encodedPassword = passwordEncoder.encode(registerUser.getPassword());
            RegisterUser user = new RegisterUser(registerUser.getUsername(), encodedPassword, registerUser.getEmail());
            userMapper.insertUser(user);
            return "success";
        }
    }
}


    

