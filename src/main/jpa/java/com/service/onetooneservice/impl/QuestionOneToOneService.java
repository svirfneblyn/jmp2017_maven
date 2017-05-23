package com.service.onetooneservice.impl;

import com.domain.relations.onetoone.QuestionOneToOne;
import com.service.onetooneservice.IQuestionOneToOneRelRepository;
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

    public List<QuestionOneToOne> findAll() {
        List<QuestionOneToOne> objects = new ArrayList<>();
        repository.findAll().forEach(objects::add);
        return objects;
    }

    public void create(QuestionOneToOne questionRel) {
        repository.save(questionRel);
    }
}
