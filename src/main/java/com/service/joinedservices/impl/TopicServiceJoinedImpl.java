package com.service.joinedservices.impl;

import com.domain.inheritance.joined.TopicJ;
import com.service.joinedservices.ITopicRepositoryJoined;
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
public class TopicServiceJoinedImpl {
    @Autowired
    private ITopicRepositoryJoined iTopicRepositoryJoined;

    public List<TopicJ> findAllTopics() {
        List<TopicJ> topicJS = new ArrayList<>();
        iTopicRepositoryJoined.findAll().forEach(topicJS::add);
        return topicJS;
    }
}
