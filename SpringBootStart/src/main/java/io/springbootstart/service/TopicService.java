package io.springbootstart.service;

import io.springbootstart.models.Topic;
import io.springbootstart.mongodb.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring","spring framework","desc"),
            new Topic("java","Core Java","core java desc"),
            new Topic("Javascript","Javascript Ex","js desc")
    ));

    public List<Topic> getAllTopics() {
        List<Topic> topics = topicRepository.findAll();
        return topics;
    }

    public Topic getTopic(String id){

        //return topics.stream().filter( topic -> topic.getId().equals(id)).findFirst().get();
        Topic topic = topicRepository.findById(id).get();
        return topic;

    }


    public Topic addTopic(Topic topic){
        topics.add(topic);
        topicRepository.save(topic);
        return  topic;
    }

    public Topic update(String topicId, Topic topic) {

        Topic topicOriginal = topicRepository.findById(topicId).get();

        if(null != topicOriginal){
            topicOriginal.setName(topic.getName());
            topicOriginal.setDescription(topic.getDescription());
            topicRepository.save(topicOriginal);
            return topicOriginal;

        }else{
            return null;
        }

    }

    public void delete(String topicId) {

        topicRepository.deleteById(topicId);
    }
}
