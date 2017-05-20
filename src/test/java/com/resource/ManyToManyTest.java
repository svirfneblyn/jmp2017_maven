package com.resource;

import com.Application;
import com.domain.relations.manytomany.QuestionManyToMany;
import com.domain.relations.manytomany.TopicManyToMany;
import com.service.manytomany.IQuestionMtM;
import com.service.manytomany.ITopicMtM;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ManyToManyTest {
    @Autowired
    private IQuestionMtM iQuestionMtM;
    @Autowired
    private ITopicMtM iTopicMtM;

    @Test
    public void mTmTest() {
       /* TopicManyToMany t1 = new TopicManyToMany();
        t1 .setTopic("theme_11");
        t1 .setTopicDescr("description_11");
        TopicManyToMany t2 = new TopicManyToMany();
        t2.setTopic("theme_22");
        t2.setTopicDescr("description_22");

        QuestionManyToMany q1 = new QuestionManyToMany();
        q1.setQuestionText("question_11111");
        q1.setQuestSc("GOOD");
        QuestionManyToMany q2 = new QuestionManyToMany();
        q2.setQuestionText("question_22222");
        q2.setQuestSc("NICE");


        t1.getQuestions().add(q1);
        t1.getQuestions().add(q2);
        q1.getTopics().add(t1);
        iTopicMtM.save(t1);
        iTopicMtM.save(t2);*/
       // iQuestionMtM.save(q1);
      //  iQuestionMtM.save(q2);

        List<QuestionManyToMany> qList = new ArrayList<>();
        iTopicMtM.findAll();
                /*.forEach( qList::add );
        qList.forEach(
                q -> System.out.println(" question Id :" + q.getQuestionId() + " QuestionEmbeded " + q.getQuestionText() +
                " QuestionScore " + q.getQuestSc() )
        );*/
    }
}

