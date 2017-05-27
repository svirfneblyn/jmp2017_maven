package com.service.joinedservices;

import com.domain.inheritance.joined.TopicJ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
public interface ITopicRepositoryJoined extends CrudRepository<TopicJ,Long> {
}
