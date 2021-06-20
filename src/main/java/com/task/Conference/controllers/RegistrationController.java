package com.task.Conference.controllers;

import com.task.Conference.entities.User;
import com.task.Conference.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, Map<String, Object> model) {

        if (!userService.saveUser(user)) {
            model.put("error", "Пользователь с таким именем существует");
            return "registration";
        }

        return "redirect:/";
    }
}
