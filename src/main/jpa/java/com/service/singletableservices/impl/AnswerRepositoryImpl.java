package com.service.singletableservices.impl;

import com.domain.inheritance.singletable.Answer;
import com.service.singletableservices.IAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@Service
public class AnswerRepositoryImpl {
    @Autowired
    private IAnswerRepository iAnswerRepository;

    public List<Answer> findAllAnswers() {
        List<Answer> answers = new ArrayList<>();
        iAnswerRepository.findAll().forEach(answers::add);
        return answers;
    }
    public void create(Answer answer){
        iAnswerRepository.save(answer);
            }
}
