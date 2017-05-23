package com.service.onetooneservice.impl;

import com.domain.relations.onetoone.TopicOneToOne;
import com.service.onetooneservice.IQuestionOneToOneRelRepository;
import com.service.onetooneservice.ITopicOneToOneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Service
@Transactional
public class TopicOneToOneService {
    @Autowired
    private ITopicOneToOneRepository iTopicOneToOneRepository;
    @Autowired
    private IQuestionOneToOneRelRepository iQuesRepo;

    public List<TopicOneToOne> findAll() {
        List<TopicOneToOne> objects = new ArrayList<>();
        iTopicOneToOneRepository.findAll().forEach(objects::add);
        return objects;
    }
    public TopicOneToOne find(Long id){
        return iTopicOneToOneRepository.findOne(id);
    }
    @Transactional
    public void create(TopicOneToOne topicRel) {
        iTopicOneToOneRepository.save(topicRel);
        System.out.println("done");

    }
}
