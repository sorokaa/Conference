package com.task.Conference.controllers;

import com.task.Conference.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }

    @ResponseBody
    @RequestMapping("/talksList")
    public String talksList(Map<String, Object> model) {
        return "talksList";
    }

}
