package com.todojava.tasklist.main.service;

import com.todojava.tasklist.main.dao.TaskMapper;
import com.todojava.tasklist.main.entity.CompTaskItem;
import com.todojava.tasklist.main.entity.RecordTaskItem;
import com.todojava.tasklist.main.entity.TaskItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<TaskItem> getAllTasks() {
        return taskMapper.findAllTasks();
    }

    public List<CompTaskItem> getAllCompTasks() {
        return taskMapper.findAllCompTasks();
    }

    public List<String> getAllUsernames() {
        return taskMapper.findAllUsers();
    }


    public TaskItem insertTask(String taskId, String client, String contractor, String task, String deadline, boolean done) {
        TaskItem taskItem = new TaskItem(taskId, client, contractor, task, deadline, done);
        taskMapper.insert(taskItem);
        return taskItem;
    }

    public void deleteTask(String taskId) {

        taskMapper.delete(taskId);
    }

    public TaskItem update(String taskId, String client, String contractor, String task, String deadline, boolean done) {
        TaskItem taskItem = new TaskItem(taskId, client, contractor, task, deadline, done);
        taskMapper.updateItem(taskItem);
        return taskItem;
    }

    public TaskItem getTaskById(String taskId) {

        return taskMapper.findById(taskId).orElse(null);
    }

    public void insertCompletedTask(CompTaskItem completedTask) {
        taskMapper.insertCompletedTask(completedTask);
        taskMapper.delete(completedTask.getTaskId());
    }

    public CompTaskItem getCompTaskById(String taskId) {

        return taskMapper.findCompById(taskId).orElse(null);
    }

    public void insertRecordTask(RecordTaskItem recordTaskItem) {
        taskMapper.insertRecordTask(recordTaskItem);
        taskMapper.deleteCompTask(recordTaskItem.getTaskId());
    }

    public void deleteCompTask(String id) {

        taskMapper.deleteCompTask(id);
    }


}


   
    
