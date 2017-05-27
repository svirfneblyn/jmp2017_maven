package com.domain.inheritance.tableperclass;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Data
@Accessors(chain = true)
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "entity_type", discriminatorType = DiscriminatorType.STRING)
public class TopicT  {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private  Long id;
}
