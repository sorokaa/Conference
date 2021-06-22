package com.task.Conference.services;

import com.task.Conference.entities.Room;
import com.task.Conference.entities.Schedule;
import com.task.Conference.entities.Talk;
import com.task.Conference.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void save(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public boolean isBusy(Room room, Timestamp timestamp) {
        List<Schedule> schedules = scheduleRepository.findByIdAndTime(room, timestamp);
        return !schedules.isEmpty();
    }

    public Schedule findByTalk(Talk talk) {
        return scheduleRepository.findByTalk(talk);
    }

    public void deleteById(Long id) {
        scheduleRepository.deleteById(id);
    }

}