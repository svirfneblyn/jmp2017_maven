package com.service.onetooneservice;

import com.domain.relations.onetoone.TopicOneToOne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface ITopicOneToOneRepository extends CrudRepository<TopicOneToOne,Long> {
}
