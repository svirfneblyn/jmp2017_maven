package com.domain.embeded;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Entity
@Table(name = "question_embeded")
@IdClass(TopicEmbeded.class)
public class QuestionEmbeded {

    QuestionEmbeded() {
    }

    QuestionEmbeded(TopicEmbeded embeded) {
        topicName = embeded.getTopicName();
        number = embeded.getNumber();
    }

    @Id
    @AttributeOverrides({
            @AttributeOverride(name = "topicName",
                    column = @Column(name = "topic_name")),
            @AttributeOverride(name = "number",
                    column = @Column(name = "topic_number"))
    })
    private String topicName;
    private int number;

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

    private String question;
    private String shortDescription;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }


}
