package com.service.singletableservices;

import com.domain.inheritance.singletable.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface ITopicRepository extends CrudRepository<Topic,Long> {
}
