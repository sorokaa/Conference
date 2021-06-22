package com.task.Conference.services;

import com.task.Conference.entities.Room;
import com.task.Conference.repositories.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ScheduleServiceTest {

    @Autowired
    private ScheduleService scheduleService;

    @MockBean
    private ScheduleRepository scheduleRepository;

    @Test
    void isBusyTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());    //Timestamp for current time
        boolean isBusy = scheduleService.isBusy(new Room(), timestamp);
        assertFalse(isBusy);
    }
}