package com.service.onetomany;

import com.domain.relations.onetomany.AnswerOnetoMany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface IAnswerOneToMany extends CrudRepository<AnswerOnetoMany,Long> {
}
