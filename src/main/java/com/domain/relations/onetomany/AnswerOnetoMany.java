package com.domain.relations.onetomany;


import com.domain.inheritance.singletable.CorrectAnswers;
import com.domain.inheritance.singletable.Topic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Domain AnswerT entity.
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "answer_one_to_many")
public class AnswerOnetoMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "answer_id")
    private Long answerId;
    @Column(name = "answer")
    private String ans;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "id")
    @OrderBy("questionId DESC")
    private QuestionOneToMany questionId;
    @Column(name = "is_answer_correct")
    @Enumerated(EnumType.STRING)
    private CorrectAnswers isCorrect;
}
