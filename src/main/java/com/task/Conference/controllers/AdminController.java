package com.task.Conference.controllers;

import com.task.Conference.entities.User;
import com.task.Conference.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin-page")
    public String usersList(Map<String, Object> model) {

        List<User> users = userService.findAll();
        model.put("users", users);
        return "admin/admin-page";
    }

    @PostMapping("/admin-page")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin-page";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin-page";
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
        return "redirect:/admin-page";
    }
}
