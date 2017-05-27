package com.service.tableperclassservices;

import com.domain.inheritance.tableperclass.TopicT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface ITopicRepositoryTablePerClass extends CrudRepository<TopicT,Long> {
}
