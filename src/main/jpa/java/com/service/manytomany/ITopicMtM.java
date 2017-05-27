package com.service.manytomany;

import com.domain.relations.manytomany.TopicManyToMany;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by.
 *
 * @author Ihar_rubanovich.
 */
@Repository
@Transactional
public interface ITopicMtM extends CrudRepository<TopicManyToMany, Long> {

   @Query("select count(t.id) from TopicManyToMany t")
   long count();
}
