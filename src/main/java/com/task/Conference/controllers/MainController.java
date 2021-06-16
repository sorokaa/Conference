package com.task.Conference.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/regestration")
    public String registrationPage() {
        return "registration";
    }

    @GetMapping("/talksList")
    public String talksList() {
        return "talksList";
    }

}
