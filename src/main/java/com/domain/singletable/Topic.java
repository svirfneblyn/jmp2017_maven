package com.domain.singletable;

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
@DiscriminatorColumn(name = "discriminator_column")
@MappedSuperclass
public class Topic extends Quizz {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "topic")
    private String topic;

}
