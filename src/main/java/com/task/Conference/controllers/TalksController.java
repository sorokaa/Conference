package com.task.Conference.controllers;

import com.task.Conference.entities.Room;
import com.task.Conference.entities.Schedule;
import com.task.Conference.entities.Talk;
import com.task.Conference.entities.User;
import com.task.Conference.services.RoomService;
import com.task.Conference.services.ScheduleService;
import com.task.Conference.services.TalkService;
import com.task.Conference.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
public class TalksController {

    private TalkService talkService;
    private UserService userService;
    private RoomService roomService;
    private ScheduleService scheduleService;

    public TalksController(TalkService talkService, UserService userService,
                           RoomService roomService, ScheduleService scheduleService) {

        this.talkService = talkService;
        this.userService = userService;
        this.roomService = roomService;
        this.scheduleService = scheduleService;
    }

    @GetMapping("/talks-list")
    public String talksList(Map<String, Object> model) {
        Iterable<Talk> talks = talkService.findAll();
        model.put("talks", talks);
        return "talk/talks-list";
    }

    @GetMapping("/talk-create")
    public String openCreatePage(Map<String, Object> model) {

        model.put("rooms", roomService.findAll());
        model.put("users", userService.findAll());
        return "talk/talk-create";
    }

    @PostMapping("/talk-create")
    public String createTalk(@RequestParam("theme") String theme,
                             @RequestParam("shortInfo") String shortInfo,
                             @RequestParam("date_of_talk") String date,
                             @RequestParam("time_of_talk") String time,
                             @RequestParam("room") Long id_room,
                             @RequestParam("users") Long[] users) {

        if (users.length == 0) {
            return "redirect:/talk-create";
        }

        Room room = roomService.findById(id_room);
        Timestamp timestamp = Timestamp.valueOf(date + " " + time + ":00");

        if (scheduleService.isBusy(room, timestamp)) {
            System.out.println("Can't create");
            return "redirect:/talk-create";
        }

        Talk talk = new Talk(theme, shortInfo);
        Set<User> speakers = new HashSet<>();
        for (Long i : users) {
            speakers.add(userService.getUserById(i));
        }
        talk.setSpeakers(speakers);

        talkService.save(talk);

        Schedule schedule = new Schedule();
        schedule.setRoom(room);
        schedule.setTalk(talk);
        schedule.setTimeOfTalk(timestamp);

        scheduleService.save(schedule);

        return "redirect:/talks-list";
    }

    @GetMapping("/talk-update/{id}")
    public String updateTalkPage(@PathVariable("id") Long id, Map<String, Object> model) {

        model.put("talk", talkService.findById(id));
        model.put("users", userService.findAll());
        model.put("rooms", roomService.findAll());

        return "talk/talk-update";
    }

    @PostMapping("/talk-update")
    public String updateTalk(@RequestParam("theme") String theme,
                             @RequestParam("shortInfo") String shortInfo,
                             @RequestParam("timeOfTalk") String time,
                             @RequestParam("room") Long id_room,
                             @RequestParam("users") Long[] users,
                             @RequestParam("id") Long id) {

        Room room = roomService.findById(id_room);
        Timestamp timestamp = Timestamp.valueOf(time);

        if (scheduleService.isBusy(room, timestamp)) {
            return "redirect:/talks-list";
        }

        Talk talk = talkService.findById(id);
        Schedule schedule = scheduleService.findByTalk(talk);

        schedule.setRoom(room);
        schedule.setTimeOfTalk(Timestamp.valueOf(time));

        talk.setTheme(theme);
        talk.setShortInfo(shortInfo);

        Set<User> speakers = new HashSet<>();
        for (Long i : users) {
            speakers.add(userService.getUserById(i));
        }
        talk.setSpeakers(speakers);

        scheduleService.save(schedule);
        talkService.save(talk);

        return "redirect:/talks-list";
    }

    @GetMapping("/talk-delete/{id}")
    public String deleteTalk(@PathVariable("id") Long id) {

        Talk talk = talkService.findById(id);

        Schedule schedule = talk.getSchedule();

        scheduleService.deleteById(schedule.getId());

        talkService.deleteById(id);

        return "redirect:/talks-list";
    }

}
