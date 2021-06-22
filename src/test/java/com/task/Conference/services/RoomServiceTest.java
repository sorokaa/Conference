package com.task.Conference.services;

import com.task.Conference.entities.Room;
import com.task.Conference.repositories.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @MockBean
    private RoomRepository roomRepository;

    @Test
    public void addRoomTest() {

        Room room = new Room();
        room.setNumber(1L);

        boolean isSaved = roomService.save(room);
        assertTrue(isSaved);

    }

}