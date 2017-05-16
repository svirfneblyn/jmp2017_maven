package com.service.onetooneservice.impl;

import com.domain.relations.onetoone.QuestionRel;
import com.domain.relations.onetoone.TopicRel;
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

    public List<TopicRel> findAll() {
        List<TopicRel> objects = new ArrayList<>();
        iTopicOneToOneRepository.findAll().forEach(objects::add);
        return objects;
    }
    @Transactional
    public void create(TopicRel topicRel, QuestionRel questionRel) {
        iQuesRepo.save(questionRel);
        topicRel.setQuestionId(questionRel);
        iTopicOneToOneRepository.save(topicRel);
        //questionRel.setRel(topicRel);

    }
}
