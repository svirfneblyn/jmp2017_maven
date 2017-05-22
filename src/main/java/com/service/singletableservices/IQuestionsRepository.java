package com.service.singletableservices;

import com.domain.inheritance.singletable.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface IQuestionsRepository extends CrudRepository<Question,Long> {
}
