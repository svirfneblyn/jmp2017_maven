package com.service.manytomany;

import com.domain.relations.manytomany.QuestionManyToMany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@Repository
public interface IQuestionMtM extends CrudRepository<QuestionManyToMany, Long> {
}
