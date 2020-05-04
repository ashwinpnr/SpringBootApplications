package io.springbootstart.mongodb.repository;

import io.springbootstart.models.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepository extends MongoRepository<Topic,String> {

}

