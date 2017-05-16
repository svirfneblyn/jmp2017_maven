package com.domain.inheritance.singletable;

import com.domain.Quizz;

import javax.persistence.*;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "entity_type", discriminatorType = DiscriminatorType.STRING)
public class Topic extends Quizz {
}
