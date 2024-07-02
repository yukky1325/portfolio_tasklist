package com.todojava.tasklist.main.service;

import com.todojava.tasklist.main.dao.HomeRestMapper;
import com.todojava.tasklist.main.entity.TaskItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeRestService {
    private final HomeRestMapper homeRestMapper;

    public HomeRestService(HomeRestMapper homeRestMapper) {
        this.homeRestMapper = homeRestMapper;
    }

    public List<TaskItem> getAllTasks() {
        return homeRestMapper.findAllTasks();
    }

    public TaskItem insertTask(String id, String task, String deadline, boolean done) {
        TaskItem taskItem = new TaskItem(id, task, deadline, done);
        homeRestMapper.insert(taskItem);
        return taskItem;
    }

    public void deleteTask(String id) {
        homeRestMapper.delete(id);
    }

    public TaskItem update(String id, String task, String deadline, boolean done) {
        TaskItem taskItem = new TaskItem(id, task, deadline, done);
        homeRestMapper.updateItem(taskItem);
        return taskItem;
    }

}


   
    
