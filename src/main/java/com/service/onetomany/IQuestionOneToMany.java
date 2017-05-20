package com.service.onetomany;

import com.domain.relations.onetomany.QuestionOneToMany;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
public interface IQuestionOneToMany extends CrudRepository<QuestionOneToMany, Long> {
}
