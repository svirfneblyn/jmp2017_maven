package com.domain.inheritance.joined;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Domain AnswerT entity
 *
 * @author Ihar_Rubanovich
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@Entity
@DiscriminatorValue(value = "ANSWER")
public class AnswerJ extends TopicJ {
    @Column(name = "replay_text")
    private String replayText;
    @Column(name = "is_answer_correct")
    @Enumerated(EnumType.STRING)
    private CorrectAnswers isCorrect;
}
