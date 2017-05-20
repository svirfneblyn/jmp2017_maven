package com.domain.embeded;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */

@Entity
@IdClass(TopicEmbeded.class)
public class AnswerEmbeded implements Serializable {

    @Id
    private String topicName;
    @Id
    private int number;

    private String Answer;

    public AnswerEmbeded() {
    }

    public AnswerEmbeded(String topicName, String answer) {
        this.topicName = topicName;
        Answer = answer;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
