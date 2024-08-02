package com.todojava.tasklist.main.controller;

import com.todojava.tasklist.main.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/task/users")
    public String showList(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String loggedInUser = userDetails.getUsername();
        com.todojava.tasklist.main.entity.UserDetails loggedInUserInfo = userService.findByUser(loggedInUser);
        model.addAttribute("username", loggedInUser);
        model.addAttribute("userList", loggedInUserInfo);
        model.addAttribute("recordTask", userService.findByRecordTask());
        return "users";
    }


}
