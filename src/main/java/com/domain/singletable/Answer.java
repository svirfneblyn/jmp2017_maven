package com.domain.singletable;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Domain Answer entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("superwarning Question")
@Entity
@Inheritance
@DiscriminatorValue(value = "ANSWER")
//@Table(name = "correct_answer")
public class Answer {
    @Id
    private int answerId;
    @Column(name = "replay_text")
    private String replayText;
    @Column(name = "is_answer_correct")
    @Enumerated(EnumType.STRING)
    private CorrectAnswers isCorrect;

}
