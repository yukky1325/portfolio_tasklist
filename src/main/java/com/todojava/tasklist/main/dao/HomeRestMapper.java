package com.todojava.tasklist.main.dao;

import com.todojava.tasklist.main.entity.TaskItem;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface HomeRestMapper {
    @Select("SELECT * FROM tasklists")
    List<TaskItem> findAllTasks();

    @Select("SELECT *FROM tasklists WHERE id = #{id}")
    Optional<TaskItem> findById(String id);

    @Insert("INSERT INTO tasklists (id,task,deadline, done) VALUES (#{id}, #{task}, #{deadline},#{done})")
    void insert(TaskItem taskItem);

    @Delete("DELETE FROM tasklists WHERE id = #{id}")
    void delete(String id);

    @Update("UPDATE tasklists SET task=#{task}, deadline=#{deadline}, done=#{done} WHERE id=#{id}")
    void updateItem(TaskItem taskItem);

}
