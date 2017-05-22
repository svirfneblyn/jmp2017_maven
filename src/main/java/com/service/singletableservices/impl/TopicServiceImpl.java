package com.service.singletableservices.impl;

import com.domain.inheritance.singletable.Topic;
import com.service.singletableservices.ITopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Service
public class TopicServiceImpl {
    @Autowired
    private ITopicRepository iTopicRepository;

    public List<Topic> findAllTopics() {
        List<Topic> topics = new ArrayList<>();
        iTopicRepository.findAll().forEach(topics::add);
        return topics;
    }
}
