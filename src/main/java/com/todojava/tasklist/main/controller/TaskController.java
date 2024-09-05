package com.todojava.tasklist.main.controller;

import com.todojava.tasklist.main.entity.CompTaskItem;
import com.todojava.tasklist.main.entity.RecordTaskItem;
import com.todojava.tasklist.main.entity.TaskItem;
import com.todojava.tasklist.main.service.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public List<TaskItem> taskItems = new ArrayList<>();


    @GetMapping("/task")
    String listHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        List<TaskItem> taskItems = taskService.getAllTasks();
        model.addAttribute("taskList", taskItems);
        List<String> usernames = taskService.getAllUsernames();
        model.addAttribute("usernames", usernames);
        List<CompTaskItem> CompTaskItems = taskService.getAllCompTasks();
        model.addAttribute("completedTask", CompTaskItems);
        return "task";
    }

    @PostMapping("/task")
    String addItem(@RequestParam("client") String client, @RequestParam("contractor") String contractor, @RequestParam("task") String task, @RequestParam("deadline") String deadline) {
        String taskId = UUID.randomUUID().toString().substring(0, 8);
        TaskItem item = new TaskItem(taskId, client, contractor, task, deadline, false);
        taskService.insertTask(item.getTaskId(), item.getClient(), item.getContractor(), item.getTask(), item.getDeadline(), item.isDone());
        return "redirect:/task";
    }

    @DeleteMapping("/task/{taskId}")
    String deleteTask(@PathVariable("taskId") String taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/task";
    }

    @PatchMapping("/task/update")
    String updateItem(@RequestParam("taskId") String taskId,
                      @RequestParam("client") String client,
                      @RequestParam("contractor") String contractor,
                      @RequestParam("task") String task,
                      @RequestParam("deadline") String deadline,
                      @RequestParam("done") boolean done) {
        taskService.update(taskId, client, contractor, task, deadline, done);
        return "redirect:/task";
    }

    @PostMapping("/task/{taskId}/complete")
    String completeTask(@PathVariable("taskId") String taskId) {
        TaskItem task = taskService.getTaskById(taskId);
        if (task != null && task.isDone()) {
            taskService.update(task.getTaskId(), task.getClient(), task.getContractor(), task.getTask(), task.getDeadline(), true);
            LocalDateTime completedDate = LocalDateTime.now();
            CompTaskItem completedTask = new CompTaskItem(task.getTaskId(), task.getClient(), task.getContractor(), task.getTask(), task.getDeadline(), completedDate);
            taskService.insertCompletedTask(completedTask);
        }
        return "redirect:/task";
    }

    @PostMapping("/task/{taskId}/completedTask")
    String completedTask(@PathVariable("taskId") String taskId) {
        CompTaskItem task = taskService.getCompTaskById(taskId);
        if (task != null) {
            LocalDateTime completedDate = LocalDateTime.now();
            RecordTaskItem recordTask = new RecordTaskItem(task.getTaskId(), task.getClient(), task.getContractor(), task.getTask(), task.getDeadline(), completedDate);
            taskService.insertRecordTask(recordTask);
        }
        return "redirect:/task";
    }

    @PostMapping("/task/{taskId}/notCompletedTask")
    String notCompletedTask(@PathVariable("taskId") String taskId) {
        CompTaskItem task = taskService.getCompTaskById(taskId);
        if (task != null) {
            taskService.insertTask(task.getTaskId(), task.getClient(), task.getContractor(), task.getTask(), task.getDeadline(), false);
            taskService.deleteCompTask(task.getTaskId());
        }
        return "redirect:/task";
    }

}
