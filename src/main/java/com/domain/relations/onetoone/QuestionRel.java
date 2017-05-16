package com.domain.relations.onetoone;

import com.domain.inheritance.singletable.Topic;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class QuestionRel {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "question_id", insertable = true, updatable = true)
    private Long questionId;
    @Column(name = "question")
    private String question;
    @OneToOne(cascade = CascadeType.MERGE , mappedBy = "questionId")
    private TopicRel rel;
}
