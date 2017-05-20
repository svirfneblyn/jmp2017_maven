package com.domain.relations.onetoone;

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
public class TopicOneToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topic_id", insertable = true, updatable = true)
    private Long id;
    @Column(name = "topic", insertable = true, updatable = true)
    private String topic;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private QuestionOneToOne questionId;
}
