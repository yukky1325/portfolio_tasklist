package com.todojava.tasklist.main.controller;

import com.todojava.tasklist.main.entity.CompTaskItem;
import com.todojava.tasklist.main.entity.TaskItem;
import com.todojava.tasklist.main.service.HomeRestService;
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
public class HomeRestController {
    private final HomeRestService homeRestService;

    public HomeRestController(HomeRestService homeRestService) {
        this.homeRestService = homeRestService;
    }

    public List<TaskItem> taskItems = new ArrayList<>();


    @GetMapping("/home")
    String listHome(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        List<TaskItem> taskItems = homeRestService.getAllTasks();
        model.addAttribute("taskList", taskItems);
        List<String> usernames = homeRestService.getAllUsernames();
        model.addAttribute("usernames", usernames);
        List<CompTaskItem> CompTaskItems = homeRestService.getAllCompTasks();
        model.addAttribute("completedTask", CompTaskItems);
        return "home";
    }

    @PostMapping("/add")
    String addItem(@RequestParam("client") String client, @RequestParam("contractor") String contractor, @RequestParam("task") String task, @RequestParam("deadline") String deadline) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        TaskItem item = new TaskItem(id, client, contractor, task, deadline, false);
        homeRestService.insertTask(item.getId(), item.getClient(), item.getContractor(), item.getTask(), item.getDeadline(), item.isDone());
        return "redirect:/home";
    }

    @DeleteMapping("/delete")
    String deleteTask(@RequestParam("id") String id) {
        homeRestService.deleteTask(id);
        return "redirect:/home";
    }

    @PatchMapping("/update")
    String updateItem(@RequestParam("id") String id,
                      @RequestParam("client") String client,
                      @RequestParam("contractor") String contractor,
                      @RequestParam("task") String task,
                      @RequestParam("deadline") String deadline,
                      @RequestParam("done") boolean done) {
        ;
        homeRestService.update(id, client, contractor, task, deadline, done);
        return "redirect:/home";
    }

    @PostMapping("/complete")
    String completeTask(@RequestParam("id") String id) {
        TaskItem task = homeRestService.getTaskById(id);
        if (task != null && task.isDone()) {
            homeRestService.update(task.getId(), task.getClient(), task.getContractor(), task.getTask(), task.getDeadline(), true);
            LocalDateTime completedDate = LocalDateTime.now();
            CompTaskItem completedTask = new CompTaskItem(task.getId(), task.getClient(), task.getContractor(), task.getTask(), task.getDeadline(), completedDate);
            homeRestService.insertCompletedTask(completedTask);
        }
        return "redirect:/home";
    }

}
