package com.resource;

import com.Application;
import com.domain.inheritance.tableperclass.AnswerT;
import com.domain.inheritance.tableperclass.CorrectAnswers;
import com.domain.inheritance.tableperclass.QuestionT;
import com.service.tableperclassservices.impl.AnswerRepositoryTableImpl;
import com.service.tableperclassservices.impl.QuestionServiceTableImpl;
import com.service.tableperclassservices.impl.TopicServiceTableImpl;
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
public class TablePerClassTest {
    @Autowired
    private AnswerRepositoryTableImpl answerRepository;
    @Autowired
    private QuestionServiceTableImpl questionService;
    @Autowired
    private TopicServiceTableImpl quizzService;

    @Before
    public void createStubTables() {
        createAnswer(CorrectAnswers.CORRECT, "The primary key class must be serializable.");
        createAnswer(CorrectAnswers.INCORRECT, "The primary key class must be NOT serializable.");
        createQuestion("Check correct answers about primary key : ");
        createQuestion("Howdoyoudo?");
    }

    @Test
    public void answersTest() {
        System.out.println("====== topics ======" + quizzService.findAllTopics());
        /*output is : [AnswerT(replayText=The primary key class must be serializable., isCorrect=CORRECT),
                       AnswerT(replayText=The primary key class must be NOT serializable., isCorrect=INCORRECT),
                       QuestionT(question=Check correct answers about primary key : ),
                       QuestionT(question=Howdoyoudo?)]

        */
        System.out.println("====== answers ======" + answerRepository.findAllAnswers());
        /*output is :
        * [AnswerT(replayText=The primary key class must be serializable., isCorrect=CORRECT),
        * AnswerT(replayText=The primary key class must be NOT serializable., isCorrect=INCORRECT)]
        */
        System.out.println("====== questions ======" + questionService.findAllQuestions());
        /*output is :
        *[QuestionT(question=Check correct answers about primary key : ), QuestionT(question=Howdoyoudo?)]
        * */
    }

    private void createAnswer(CorrectAnswers ca, String replayText) {
        answerRepository.create(new AnswerT()
                .setIsCorrect(ca)
                .setReplayText(replayText));
    }

    private void createQuestion(String question) {
        questionService.create(
                new QuestionT()
                        .setQuestion(question)
        );
    }
}
