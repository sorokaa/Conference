package com.task.Conference.repositories;

import com.task.Conference.entities.Room;
import com.task.Conference.entities.Schedule;
import com.task.Conference.entities.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query(value = "SELECT u FROM Schedule u WHERE u.room = :room and u.timeOfTalk = :time")
    List<Schedule> findByIdAndTime(@Param("room") Room room,
                                   @Param("time") Timestamp time);

    @Transactional
    @Modifying
    @Query("DELETE FROM Schedule u WHERE u.talk = :talk")
    void deleteByTalk(@Param("talk") Talk talk);


    Schedule findByTalk(Talk talk);

}