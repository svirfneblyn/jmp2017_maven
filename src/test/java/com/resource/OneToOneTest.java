package com.resource;

import com.Application;
import com.domain.relations.onetoone.QuestionOneToOne;
import com.domain.relations.onetoone.TopicOneToOne;
import com.service.onetooneservice.impl.QuestionOneToOneService;
import com.service.onetooneservice.impl.TopicOneToOneService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OneToOneTest {

    @Autowired
    private TopicOneToOneService topicService;

    @Test
    public void answersTest() {
        createTopic("t2");
        TopicOneToOne trr = topicService.find(4L);
        System.out.println("=== topic : " + trr.getTopic() + " id : " + trr.getId() + " question_Id  " + trr.getQuestionId().getQuestionId());
    }
    /*  output :
    *       ======  topic : t2 id : 4 question_Id  4
    * */
    private TopicOneToOne createTopic(String topic) {
        TopicOneToOne tr = new TopicOneToOne().setTopic(topic);
        QuestionOneToOne q1 = new QuestionOneToOne().setQuestion(topic + "_question" );
        tr.setQuestionId(q1);
        topicService.create(tr);
        return tr;
    }
}
