package com.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Domain Quizz abstract entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@MappedSuperclass
public abstract class Quizz implements Serializable {
    @Id
    @GeneratedValue
    private Long quizId;
    private String name;
}
