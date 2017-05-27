package com.domain.inheritance.joined;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Domain QuestionT entity
 *
 * @author Ihar_Rubanovich
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
@Entity
@DiscriminatorValue(value = "QUESTION")
public class Question extends TopicJ {

    private String question;
}
