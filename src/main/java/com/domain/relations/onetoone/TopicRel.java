package com.domain.relations.onetoone;

import com.domain.Quizz;
import com.domain.inheritance.joined.Question;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "topic_rel")
public class TopicRel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id", insertable = true, updatable = true)
    private Long id;
    @Column(name = "topic", insertable = true, updatable = true)
    private String topic;
    @OneToOne
    @JoinColumn(name = "question_id")
    private QuestionRel questionId;
}
