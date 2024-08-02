package com.todojava.tasklist.main.dao;

import com.todojava.tasklist.main.entity.CompTaskItem;
import com.todojava.tasklist.main.entity.RecordTaskItem;
import com.todojava.tasklist.main.entity.TaskItem;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface TaskMapper {
    @Select("SELECT * FROM active_tasklists")
    List<TaskItem> findAllTasks();

    @Select("SELECT * FROM completed_tasklists")
    @Results({
            @Result(property = "taskId", column = "task_id"),
            @Result(property = "client", column = "client"),
            @Result(property = "contractor", column = "contractor"),
            @Result(property = "task", column = "task"),
            @Result(property = "deadline", column = "deadline"),
            @Result(property = "completedDate", column = "completed_date", javaType = LocalDateTime.class)
    })
    List<CompTaskItem> findAllCompTasks();

    @Select("SELECT username FROM users")
    List<String> findAllUsers();

    @Select("SELECT * FROM active_tasklists WHERE task_id = #{taskId}")
    Optional<TaskItem> findById(String taskId);

    @Insert("INSERT INTO active_tasklists (task_id,client,contractor,task,deadline, done) VALUES (#{taskId}, #{client},#{contractor},#{task}, #{deadline},#{done})")
    void insert(TaskItem taskItem);

    @Delete("DELETE FROM active_tasklists WHERE task_id = #{taskId}")
    void delete(String taskId);

    @Update("UPDATE active_tasklists SET client=#{client},contractor=#{contractor},task=#{task}, deadline=#{deadline}, done=#{done} WHERE task_id=#{taskId}")
    void updateItem(TaskItem taskItem);

    @Insert("INSERT INTO completed_tasklists (task_id,client,contractor,task,deadline,completed_date) VALUES (#{taskId}, #{client},#{contractor},#{task}, #{deadline}, #{completedDate})")
    void insertCompletedTask(CompTaskItem CompletedTask);

    @Select("SELECT * FROM completed_tasklists WHERE task_id = #{taskId}")
    Optional<CompTaskItem> findCompById(String taskId);

    @Delete("DELETE FROM completed_tasklists WHERE task_id = #{taskId}")
    void deleteCompTask(String taskId);

    @Insert("INSERT INTO record_tasklists (task_id,client,contractor,task,deadline,completed_date) VALUES (#{taskId}, #{client},#{contractor},#{task}, #{deadline}, #{completedDate})")
    void insertRecordTask(RecordTaskItem recordTaskItem);


}
