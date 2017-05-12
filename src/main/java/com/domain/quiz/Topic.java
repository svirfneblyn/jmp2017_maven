package com.domain.quiz;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Domain Topic entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("superwarningTopic")
@Entity
@Inheritance
@DiscriminatorColumn()
@Table(name ="quiz")
public abstract class Topic {
    @Id
    private int id;
    private String topic;

}
