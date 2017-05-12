package com.domain.singletable;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Domain Question entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("superwarning Question")
@Entity
@Inheritance

@DiscriminatorValue(value = "QUESTION")
public class Question extends Topic {
    @Id
    private Long question_id;
    private String question;
}
