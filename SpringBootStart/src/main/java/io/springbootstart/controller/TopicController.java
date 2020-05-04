package io.springbootstart.controller;

import io.springbootstart.models.Topic;
import io.springbootstart.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/getAllTopics")
     public ResponseEntity<List<Topic>> getAllTopics(){

        List<Topic> topics= topicService.getAllTopics();

        return new ResponseEntity<>(topics, HttpStatus.OK);
     }

     @GetMapping("{topicId}")
     public ResponseEntity<Topic> getTopic(@PathVariable("topicId") String topicId){

        Topic topic = topicService.getTopic(topicId);
        return new ResponseEntity<>(topic,HttpStatus.OK);
     }

     @PostMapping
     public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){

            topicService.addTopic(topic);
         return new ResponseEntity<>(topic,HttpStatus.CREATED);
     }

    @PutMapping(value = "/{topicId}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic,@PathVariable("topicId") String topicId){
        Topic topicRespose = topicService.update(topicId,topic);
        return new ResponseEntity<>(topic,HttpStatus.OK);
    }

    @DeleteMapping(value = "/{topicId}")
    public ResponseEntity<String> deleteTopic(@PathVariable("topicId") String topicId){
        topicService.delete(topicId);
        return new ResponseEntity<>("Topic Deleted "+topicId,HttpStatus.OK);
    }



}
