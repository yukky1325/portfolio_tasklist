package com.todojava.tasklist.main.controller;

import com.todojava.tasklist.main.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showList(Model model) {
        model.addAttribute("userList", userService.findAll());
        return "users";
    }

}
