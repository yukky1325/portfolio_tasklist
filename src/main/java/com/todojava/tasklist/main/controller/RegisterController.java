package com.todojava.tasklist.main.controller;

import com.todojava.tasklist.main.entity.RegisterUser;
import com.todojava.tasklist.main.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String RegistrationForm(Model model) {

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterUser registerUser, Model model) {
        String result = registerService.insertUser(registerUser);
        if ("success".equals(result)) {
            return "result";
        } else {
            model.addAttribute("errorMessage", result);
            return "register";
        }
    }
}
