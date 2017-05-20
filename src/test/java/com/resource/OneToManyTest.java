package com.resource;

import com.Application;
import com.domain.inheritance.singletable.CorrectAnswers;
import com.domain.relations.onetomany.AnswerOnetoMany;
import com.domain.relations.onetomany.QuestionOneToMany;
import com.service.onetomany.IAnswerOneToMany;
import com.service.onetomany.IQuestionOneToMany;
import com.service.singletableservices.IAnswerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OneToManyTest {
    @Autowired
    private IQuestionOneToMany repo;
    @Autowired
    private IAnswerOneToMany iAnswerRepo;

    @Test
    public void tableTest() {
        QuestionOneToMany qom = create("question1");
        repo.save(qom);
        QuestionOneToMany qom2 = repo.findOne(1L);
        System.out.println(qom2.toString());

    }

    public QuestionOneToMany create(String question) {
        Set<AnswerOnetoMany> answSet = new HashSet<>();
        QuestionOneToMany qom = new QuestionOneToMany();
        qom.setQuestion(question);
        AnswerOnetoMany aom1 = new AnswerOnetoMany().setIsCorrect(CorrectAnswers.CORRECT).setAns("ans1");
        AnswerOnetoMany aom2 = new AnswerOnetoMany().setIsCorrect(CorrectAnswers.CORRECT).setAns("ans2");
        iAnswerRepo.save(aom1);
        iAnswerRepo.save(aom2);
        answSet.add(aom1);
        answSet.add(aom2);
        qom.setQuestionId(answSet);
        return qom;
    }
}
