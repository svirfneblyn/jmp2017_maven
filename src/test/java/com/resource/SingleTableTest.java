package com.resource;

import com.Application;
import com.domain.inheritance.singletable.*;
import com.service.singletableservices.impl.AnswerRepositoryImpl;
import com.service.singletableservices.impl.QuestionServiceImpl;
import com.service.singletableservices.impl.TopicServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SingleTableTest {
    @Autowired
    private AnswerRepositoryImpl answerRepository;
    @Autowired
    private QuestionServiceImpl questionService;
    @Autowired
    private TopicServiceImpl quizzService;


    @Before
    public void createStubTables() {
        createAnswer(CorrectAnswers.CORRECT, "The primary key class must be serializable.");
        createAnswer(CorrectAnswers.INCORRECT, "The primary key class must be NOT serializable.");
        createQuestion("Check correct answers about primary key : ");
        createQuestion("Howdoyoudo?");
    }

    @Test
    public void answersTest() {
        System.out.println(quizzService.findAllTopics());
        /*output is : [AnswerT(answers=The primary key class must be serializable., isCorrect=CORRECT),
                  AnswerT(answers=The primary key class must be NOT serializable., isCorrect=INCORRECT),
                  QuestionT(question=Check correct answers about primary key : ),
                  QuestionT(question=Howdoyoudo?)]
        */
        System.out.println(answerRepository.findAllAnswers());
        /*output is :
        * [AnswerT(answers=The primary key class must be serializable., isCorrect=CORRECT),
        * AnswerT(answers=The primary key class must be NOT serializable., isCorrect=INCORRECT)]
        */
        System.out.println(questionService.findAllQuestions());
        /*output is :
        * [QuestionT(question=Check correct answers about primary key : ), QuestionT(question=Howdoyoudo?)]
        * */
    }

    private void createAnswer(CorrectAnswers ca, String replayText) {
        answerRepository.create(new Answer()
                .setIsCorrect(ca)
                .setReplayText(replayText));
    }

    private void createQuestion(String question) {
        questionService.create(
                new Question()
                        .setQuestion(question)
        );
    }
}
