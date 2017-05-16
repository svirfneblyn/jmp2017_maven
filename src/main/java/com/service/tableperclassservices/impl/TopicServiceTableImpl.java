package com.service.tableperclassservices.impl;

import com.domain.inheritance.tableperclass.TopicT;
import com.service.tableperclassservices.ITopicRepositoryTablePerClass;
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
public class TopicServiceTableImpl {
    @Autowired
    private ITopicRepositoryTablePerClass iTopicRepository;

    public List<TopicT> findAllTopics() {
        List<TopicT> topics = new ArrayList<>();
        iTopicRepository.findAll().forEach(topics::add);
        return topics;
    }
}
