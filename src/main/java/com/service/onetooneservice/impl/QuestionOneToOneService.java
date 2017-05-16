package com.service.onetooneservice.impl;

import com.domain.relations.onetoone.QuestionRel;
import com.domain.relations.onetoone.TopicRel;
import com.service.onetooneservice.IQuestionOneToOneRelRepository;
import com.service.singletableservices.IQuestionsRepository;
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
public class QuestionOneToOneService {
    @Autowired
    private IQuestionOneToOneRelRepository repository;

    public List<QuestionRel> findAll() {
        List<QuestionRel> objects = new ArrayList<>();
        repository.findAll().forEach(objects::add);
        return objects;
    }

    public void create(QuestionRel questionRel) {
        repository.save(questionRel);
    }
}
