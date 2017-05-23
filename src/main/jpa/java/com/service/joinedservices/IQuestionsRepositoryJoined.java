package com.service.joinedservices;

import com.domain.inheritance.joined.Question;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface IQuestionsRepositoryJoined extends CrudRepository<Question,Long> {
}
