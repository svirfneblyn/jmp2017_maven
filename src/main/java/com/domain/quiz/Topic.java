package com.domain.quiz;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Domain Topic entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@Entity
public abstract class Topic {
    @Id
    private int id;
    private String topic;

}
