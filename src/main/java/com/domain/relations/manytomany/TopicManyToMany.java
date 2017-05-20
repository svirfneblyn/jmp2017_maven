package com.domain.relations.manytomany;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
/*@Data
@Accessors(chain = true)*/
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Cacheable
@Table(name = "topic_mtm")
public class TopicManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long id;
    @Column(name = "topic", insertable = true, updatable = true)
    private String topic;

    @Column(name = "topic_descr", insertable = true, updatable = true)
    private String topicDescr;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "topic_question",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    private Set<QuestionManyToMany> questions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopicDescr() {
        return topicDescr;
    }

    public void setTopicDescr(String topicDescr) {
        this.topicDescr = topicDescr;
    }

    public Set<QuestionManyToMany> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionManyToMany> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopicManyToMany)) return false;

        TopicManyToMany that = (TopicManyToMany) o;

        if (!getTopic().equals(that.getTopic())) return false;
        if (!getTopicDescr().equals(that.getTopicDescr())) return false;
        return getQuestions().equals(that.getQuestions());
    }

    @Override
    public int hashCode() {
        int result = getTopic().hashCode();
        result = 31 * result + getTopicDescr().hashCode();
        result = 31 * result + getQuestions().hashCode();
        return result;
    }
}

