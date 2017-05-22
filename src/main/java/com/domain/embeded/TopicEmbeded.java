package com.domain.embeded;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Embeddable
public class TopicEmbeded implements Serializable {

    private String topicName;
    private int number;

    public TopicEmbeded() {
    }

    public TopicEmbeded(String topicName, int number) {
        this.topicName = topicName;
        this.number = number;
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
}
