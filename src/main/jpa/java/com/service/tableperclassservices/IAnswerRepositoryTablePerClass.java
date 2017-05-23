package com.service.tableperclassservices;

import com.domain.inheritance.tableperclass.AnswerT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_Rubanovich.
 */
@Repository
public interface IAnswerRepositoryTablePerClass extends CrudRepository<AnswerT, Long> {

}
