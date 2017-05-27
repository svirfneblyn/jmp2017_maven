package com.service.tableperclassservices.impl;

import com.domain.inheritance.tableperclass.QuestionT;
import com.service.tableperclassservices.IQuestionsRepositoryTablePerClass;
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
public class QuestionServiceTableImpl {
    @Autowired
    private IQuestionsRepositoryTablePerClass iQuestionsRepository;

    public void create(QuestionT question) {
        iQuestionsRepository.save(question);
    }

    public List<QuestionT> findAllQuestions() {
        List<QuestionT> questions = new ArrayList<>();
        iQuestionsRepository.findAll().forEach(questions::add);
        return questions;
    }

    public QuestionT findById(Long id) {
        return iQuestionsRepository.findOne(id);
    }
}
