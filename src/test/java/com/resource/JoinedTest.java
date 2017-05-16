package com.resource;

import com.Application;
import com.domain.inheritance.joined.AnswerJ;
import com.domain.inheritance.joined.CorrectAnswers;
import com.domain.inheritance.joined.Question;
import com.service.joinedservices.impl.AnswerRepositoryJoinedImpl;
import com.service.joinedservices.impl.QuestionServiceJoinedImpl;
import com.service.joinedservices.impl.TopicServiceJoinedImpl;

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
public class JoinedTest {

    @Autowired
    private AnswerRepositoryJoinedImpl answerRepository;
    @Autowired
    private QuestionServiceJoinedImpl questionService;
    @Autowired
    private TopicServiceJoinedImpl quizzService;


    @Before
    public void createStubTables() {
        createAnswer(CorrectAnswers.CORRECT, "The primary key class must be serializable.");
        createAnswer(CorrectAnswers.INCORRECT, "The primary key class must be NOT serializable.");
        createQuestion("Check correct answers about primary key : ");
        createQuestion("Howdoyoudo?");
    }

    @Test
    public void answersTest() {
        System.out.println("======== " + quizzService.findAllTopics());
        /*output is :[AnswerT(replayText=The primary key class must be serializable., isCorrect=CORRECT),
                     AnswerT(replayText=The primary key class must be NOT serializable., isCorrect=INCORRECT),
                     QuestionT(question=Check correct answers about primary key : ),
                     QuestionT(question=Howdoyoudo?)]

        */
        System.out.println("======== " + answerRepository.findAllAnswers());
        /*output is :
        * [AnswerT(replayText=The primary key class must be serializable., isCorrect=CORRECT),
         * AnswerT(replayText=The primary key class must be NOT serializable., isCorrect=INCORRECT)]
        */
        System.out.println("======== " + questionService.findAllQuestions());
        /*output is :
        * []   ????
        * */
    }

    private void createAnswer(CorrectAnswers ca, String replayText) {
        answerRepository.create(new AnswerJ()
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
