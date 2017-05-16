package com.resource;

import com.Application;
import com.domain.inheritance.joined.Question;
import com.domain.inheritance.tableperclass.AnswerT;
import com.domain.inheritance.tableperclass.CorrectAnswers;
import com.domain.inheritance.tableperclass.QuestionT;
import com.domain.relations.onetoone.QuestionRel;
import com.domain.relations.onetoone.TopicRel;
import com.service.onetooneservice.impl.QuestionOneToOneService;
import com.service.onetooneservice.impl.TopicOneToOneService;
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
public class OneToOneTest {
    @Autowired
    private TopicOneToOneService topicService;
    @Autowired
    private QuestionOneToOneService questionService;

    @Before
    public void createStubTables() {
        QuestionRel q1 = new QuestionRel()
                .setQuestion("q1");
        TopicRel tr = new TopicRel()
                .setTopic("t1");
        topicService.create(tr,q1);
       // createQuestion(createTopic("topic_1"),"Check correct answers about primary key : ");
       // createQuestion(createTopic("topic_2"),"Howdoyoudo?");
    }

    @Test
    public void answersTest() {
        System.out.println("====== topics ======" + topicService.findAll());
        /*output is : [AnswerT(replayText=The primary key class must be serializable., isCorrect=CORRECT),
                       AnswerT(replayText=The primary key class must be NOT serializable., isCorrect=INCORRECT),
                       QuestionT(question=Check correct answers about primary key : ),
                       QuestionT(question=Howdoyoudo?)]

        */
        System.out.println("====== questions ======" + questionService.findAll());
        /*output is :
        * [AnswerT(replayText=The primary key class must be serializable., isCorrect=CORRECT),
        * AnswerT(replayText=The primary key class must be NOT serializable., isCorrect=INCORRECT)]
        */
    }

    private TopicRel createTopic(String topic) {
        TopicRel rel = new TopicRel()
                .setTopic(topic);
      //  topicService.create(rel);
        return rel;
    }

    private void createQuestion(TopicRel topicRel, String question) {
        questionService.create(
                new QuestionRel()
                        .setQuestion(question)
                        .setRel(topicRel));
    }
}
