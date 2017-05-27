package com.service.tableperclassservices.impl;

import com.domain.inheritance.tableperclass.AnswerT;
import com.service.tableperclassservices.IAnswerRepositoryTablePerClass;
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
public class AnswerRepositoryTableImpl {
    @Autowired
    private IAnswerRepositoryTablePerClass iAnswerRepository;

    public List<AnswerT> findAllAnswers() {
        List<AnswerT> answers = new ArrayList<>();
        iAnswerRepository.findAll().forEach(answers::add);
        return answers;
    }
    public void create(AnswerT answer){
        iAnswerRepository.save(answer);
            }
}
