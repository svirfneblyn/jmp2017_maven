package com.service.singletableservices;

import com.domain.inheritance.singletable.Answer;
import com.domain.relations.onetomany.AnswerOnetoMany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@Repository
public interface IAnswerRepository extends CrudRepository<Answer, Long> {

}
