package com.domain.inheritance.joined;

import com.domain.Quizz;

import javax.persistence.*;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "entity_type", discriminatorType = DiscriminatorType.STRING)
public class TopicJ extends Quizz {
}
