package com.task.Conference.dao;

import com.task.Conference.entities.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomDao extends CrudRepository<Room, Long> {

}
