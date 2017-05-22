package com.service.manytomany;

import com.domain.relations.manytomany.TopicManyToMany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
@Transactional
public interface ITopicMtM extends CrudRepository<TopicManyToMany,Long> {
}
