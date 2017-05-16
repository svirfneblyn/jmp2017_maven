package com.domain.relations.manytomany;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Domain QuestionT entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name = "question_many_to_many")
public class QuestionManyToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id", insertable = true, updatable = true)
    private Long questionId;
    @Column(name = "question")
    private String question;
    @ManyToMany
    @JoinTable(name = "topic_many_to_many",
            joinColumns = @JoinColumn(name = "topic_id"),
            //внешний ключ присоеденяемой таблицы (с той стороны)
            inverseJoinColumns = @JoinColumn(name = "question_id"))
    //можно установить связь Ж    @ManyToMany(mappedBy = "questions")
    private Set<TopicManyToMany> topics = new HashSet<>();
}
