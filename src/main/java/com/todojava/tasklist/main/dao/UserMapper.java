package com.todojava.tasklist.main.dao;

import com.todojava.tasklist.main.entity.RecordTaskItem;
import com.todojava.tasklist.main.entity.RegisterUser;
import com.todojava.tasklist.main.entity.User;
import com.todojava.tasklist.main.entity.UserDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE username = #{username}")
    Optional<User> findByUsername(String username);

    @Select("SELECT * FROM users WHERE username = #{username}")
    Optional<UserDetails> findUserInfo(String username);

    @Select("SELECT * FROM users WHERE username = #{username} OR email = #{email}")
    Optional<RegisterUser> findByUser(String username, String email);

    @Select("SELECT * FROM users")
    List<UserDetails> findAll();

    @Insert("INSERT INTO users(username, password, email) VALUES(#{username},#{password},#{email})")
    void insertUser(RegisterUser user);

    @Select("SELECT * FROM record_tasklists")
    List<RecordTaskItem> findAllRecordTask();
}
    
