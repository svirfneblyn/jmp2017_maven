package com.service.joinedservices.impl;

import com.domain.inheritance.joined.AnswerJ;
import com.service.joinedservices.IAnswerRepositoryJoined;
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
public class AnswerRepositoryJoinedImpl {
    @Autowired
    private IAnswerRepositoryJoined iAnswerRepositoryJoined;

    public List<AnswerJ> findAllAnswers() {
        List<AnswerJ> answerJS = new ArrayList<>();
        iAnswerRepositoryJoined.findAll().forEach(answerJS::add);
        return answerJS;
    }
    public void create(AnswerJ answerJ){
        iAnswerRepositoryJoined.save(answerJ);
            }
}
