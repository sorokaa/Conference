package com.task.Conference.controllers;

import com.task.Conference.entities.User;
import com.task.Conference.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/adminPage")
    public String usersList(Map<String, Object> model) {

        Iterable<User> users = userService.findAll();
        model.put("users", users);

        return "admin/adminPage";
    }

    @PostMapping("/adminPage")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/adminPage";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/adminPage";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Map<String, Object> model) {
        User user = userService.getUserById(id);
        model.put("user", user);
        return "admin/user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/adminPage";
    }


}
