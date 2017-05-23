package com.service.tableperclassservices;

import com.domain.inheritance.tableperclass.QuestionT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface IQuestionsRepositoryTablePerClass extends CrudRepository<QuestionT,Long> {
}
