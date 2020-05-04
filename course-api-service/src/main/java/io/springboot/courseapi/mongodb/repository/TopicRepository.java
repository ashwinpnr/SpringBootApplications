package io.springboot.courseapi.mongodb.repository;

import io.springboot.courseapi.models.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepository extends MongoRepository<Topic,String> {

}

