package com.service.joinedservices;

import com.domain.inheritance.joined.AnswerJ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@Repository
public interface IAnswerRepositoryJoined extends CrudRepository<AnswerJ, Long> {

}
