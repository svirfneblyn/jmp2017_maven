package com.domain.singletable;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Domain Quizz abstract entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("superwarningTopic")
@Inheritance
@Table(name ="quiz")
public abstract class Quizz {
    @Id
    @Column(name = "" )
    private Long quizId;
}
