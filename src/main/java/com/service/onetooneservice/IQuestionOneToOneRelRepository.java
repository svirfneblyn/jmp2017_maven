package com.service.onetooneservice;

import com.domain.relations.onetoone.QuestionRel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface IQuestionOneToOneRelRepository extends CrudRepository<QuestionRel, Long> {
}
