package com.todojava.tasklist.main.dao;

import com.todojava.tasklist.main.entity.CompTaskItem;
import com.todojava.tasklist.main.entity.TaskItem;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface HomeRestMapper {
    @Select("SELECT * FROM active_tasklists")
    List<TaskItem> findAllTasks();

    @Select("SELECT * FROM completed_tasklists")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "client", column = "client"),
            @Result(property = "contractor", column = "contractor"),
            @Result(property = "task", column = "task"),
            @Result(property = "deadline", column = "deadline"),
            @Result(property = "completedDate", column = "completed_date", javaType = LocalDateTime.class)
    })
    List<CompTaskItem> findAllCompTasks();

    @Select("SELECT username FROM users")
    List<String> findAllUsers();

    @Select("SELECT * FROM active_tasklists WHERE id = #{id}")
    Optional<TaskItem> findById(String id);

    @Insert("INSERT INTO active_tasklists (id,client,contractor,task,deadline, done) VALUES (#{id}, #{client},#{contractor},#{task}, #{deadline},#{done})")
    void insert(TaskItem taskItem);

    @Delete("DELETE FROM active_tasklists WHERE id = #{id}")
    void delete(String id);

    @Update("UPDATE active_tasklists SET client=#{client},contractor=#{contractor},task=#{task}, deadline=#{deadline}, done=#{done} WHERE id=#{id}")
    void updateItem(TaskItem taskItem);

    @Insert("INSERT INTO completed_tasklists (id,client,contractor,task,deadline,completed_date) VALUES (#{id}, #{client},#{contractor},#{task}, #{deadline}, #{completedDate})")
    void insertCompletedTask(CompTaskItem CompletedTask);
}
