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
@Table(name = "one_to_many")
public class AnswerOnetoMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;
    @Column(name = "replay_text")
    @ManyToOne(fetch=FetchType.LAZY)
    private String replayText;
    @Column(name = "is_answer_correct")
    @Enumerated(EnumType.STRING)
    private CorrectAnswers isCorrect;
}
