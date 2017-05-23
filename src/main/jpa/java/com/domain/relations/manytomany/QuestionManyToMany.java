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
import java.util.HashSet;
import java.util.Set;

/**
 * Domain QuestionT entity
 *
 * @author Ihar_Rubanovich
 */
/*@Data
@Accessors(chain = true)*/
@Entity
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Cacheable
@Table(name = "question_mtm")
public class QuestionManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", insertable = true, updatable = true)
    private Long questionId;
    @Column(name = "question_text")
    private String questionText;

    @Column(name="question_score")
    private String questSc;
    @ManyToMany(mappedBy = "questions",fetch = FetchType.EAGER)
    private Set<TopicManyToMany> topics = new HashSet<>();

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestSc() {
        return questSc;
    }

    public void setQuestSc(String questSc) {
        this.questSc = questSc;
    }

    public Set<TopicManyToMany> getTopics() {
        return topics;
    }

    public void setTopics(Set<TopicManyToMany> topics) {
        this.topics = topics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof QuestionManyToMany)) return false;

        QuestionManyToMany that = (QuestionManyToMany) o;

        if (!getQuestionText().equals(that.getQuestionText())) return false;
        return getQuestSc().equals(that.getQuestSc());
    }

    @Override
    public int hashCode() {
        int result = getQuestionText().hashCode();
        result = 31 * result + getQuestSc().hashCode();
        return result;
    }
}
