package com.task.Conference.services;

import com.task.Conference.repositories.RoomRepository;
import com.task.Conference.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    public Room findById(Long id) {
        return roomRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    public boolean save(Room room) {

        Room roomFromDB = roomRepository.findByNumber(room.getNumber());
        if (roomFromDB != null) {
            return false;
        }

        roomRepository.save(room);
        return true;
    }

    public Room findByNumber(Long number) {
        return roomRepository.findByNumber(number);
    }

}
