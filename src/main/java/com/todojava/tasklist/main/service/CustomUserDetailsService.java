package com.todojava.tasklist.main.service;

import com.todojava.tasklist.main.dao.UserMapper;
import com.todojava.tasklist.main.entity.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userMapper.findByUsername(username)
                .map(
                        user -> new CustomUserDetails(
                                user.getUsername(),
                                user.getPassword(),
                                Collections.emptyList()

                        )
                )
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                "Given username is not found. (username = '" + username + "')"
                        )
                );
    }
}

