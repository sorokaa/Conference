package com.task.Conference.dao;

import com.task.Conference.entities.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleDao extends CrudRepository<Schedule, Long> {
}
