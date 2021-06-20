package com.task.Conference.controllers;

import com.task.Conference.entities.Room;
import com.task.Conference.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private RoomService roomService;

    @Autowired
    public MainController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/")
    public String mainPage(Map<String, Object> model) {
        List<Room> rooms = roomService.findAll();
        model.put("rooms", rooms);
        return "index";
    }

    @GetMapping("/registration")
    public String registrationPage() {
        return "registration";
    }
}