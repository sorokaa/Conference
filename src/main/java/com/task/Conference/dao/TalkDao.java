package com.task.Conference.dao;

import com.task.Conference.entities.Talk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkDao extends CrudRepository<Talk, Long> {
}
