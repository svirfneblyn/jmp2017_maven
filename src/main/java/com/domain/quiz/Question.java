package com.domain.quiz;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/**
 * Domain Question entity
 *
 * @author Ihar_Rubanovich
 */
@Data
@Accessors(chain = true)
@SuppressWarnings("superwarning Question")
@Entity
@Inheritance
@DiscriminatorColumn()
@Table(name ="question")
public class Question  extends  Topic{

}
