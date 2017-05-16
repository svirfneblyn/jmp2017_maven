package com.service.onetooneservice;

import com.domain.relations.onetoone.TopicRel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface ITopicOneToOneRepository extends CrudRepository<TopicRel,Long> {
}
