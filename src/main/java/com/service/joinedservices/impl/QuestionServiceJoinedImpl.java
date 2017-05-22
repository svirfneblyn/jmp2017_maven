package com.service.joinedservices.impl;

import com.domain.inheritance.joined.Question;
import com.service.joinedservices.IQuestionsRepositoryJoined;
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
public class QuestionServiceJoinedImpl {
    @Autowired
    private IQuestionsRepositoryJoined iQuestionsRepositoryJoined;

    public void create(Question question) {
        iQuestionsRepositoryJoined.save(question);
    }

    public List<Question> findAllQuestions() {
        List<Question> questions = new ArrayList<>();
        iQuestionsRepositoryJoined.findAll().forEach(questions::add);
        return questions;
    }

    public Question findById(Long id) {
        return iQuestionsRepositoryJoined.findOne(id);
    }
}
