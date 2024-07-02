package com.todojava.tasklist.main.controller;

import com.todojava.tasklist.main.entity.TaskItem;
import com.todojava.tasklist.main.service.HomeRestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        List<TaskItem> taskItems = homeRestService.getAllTasks();
        model.addAttribute("taskList", taskItems);
        return "home";
    }
    
    @PostMapping("/add")
    String addItem(@RequestParam("task") String task, @RequestParam("deadline") String deadline) {
        String id = UUID.randomUUID().toString().substring(0, 8);
        TaskItem item = new TaskItem(id, task, deadline, false);
        homeRestService.insertTask(item.getId(), item.getTask(), item.getDeadline(), item.isDone());
        return "redirect:/home";
    }

    @DeleteMapping("/delete")
    String deleteTask(@RequestParam("id") String id) {
        homeRestService.deleteTask(id);
        return "redirect:/home";
    }

    @PatchMapping("/update")
    String updateItem(@RequestParam("id") String id,
                      @RequestParam("task") String task,
                      @RequestParam("deadline") String deadline,
                      @RequestParam("done") boolean done) {
        ;
        homeRestService.update(id, task, deadline, done);
        return "redirect:/home";
    }

}
