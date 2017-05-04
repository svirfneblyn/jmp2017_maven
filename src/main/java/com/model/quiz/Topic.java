package com.model.quiz;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by User on 5/4/2017.
 */
@Entity
public class Topic {
@Id

private int id;
private String topic;

    public Topic(int id, String topic) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
