package com.domain.relations.onetoone;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Domain QuestionT entity
 *
 * @author Ihar_Rubanovich
 */

@Data
@Accessors(chain = true)
@Entity
@Table(name = "question_rel")
public class QuestionOneToOne {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    @Column(name = "question_id", insertable = true, updatable = true)
    private Long questionId;
    @Column(name = "question")
    private String question;
    @OneToOne(mappedBy = "questionId",cascade=CascadeType.MERGE)
    private TopicOneToOne topicId;
}
