package com.task.Conference.services;

import com.task.Conference.repositories.TalkRepository;
import com.task.Conference.entities.Talk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalkService {

    private TalkRepository talksRepository;

    @Autowired
    public TalkService(TalkRepository talksRepository) {
        this.talksRepository = talksRepository;
    }

    public Iterable<Talk> findAll() {
        return talksRepository.findAll();
    }

    public void save(Talk talk) {
        talksRepository.save(talk);
    }

    public Talk findById(Long id) {
        return talksRepository.findById(id).get();
    }

    public void deleteById(Long id) {
        talksRepository.deleteById(id);
    }

}
