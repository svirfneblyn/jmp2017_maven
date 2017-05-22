package com.service.singletableservices.impl;

import com.domain.inheritance.singletable.Question;
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
public class QuestionServiceImpl {
    @Autowired
    private IQuestionsRepository iQuestionsRepository;

    public void create(Question question) {
        iQuestionsRepository.save(question);
    }

    public List<Question> findAllQuestions() {
        List<Question> questions = new ArrayList<>();
        iQuestionsRepository.findAll().forEach(questions::add);
        return questions;
    }

    public Question findById(Long id) {
        return iQuestionsRepository.findOne(id);
    }
}
