package com.domain.relations.onetomany;

import com.domain.inheritance.singletable.Topic;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Set;

/**
 * Domain QuestionT entity.
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "question_one_to_many")
public class QuestionOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<AnswerOnetoMany> questionId;
}
