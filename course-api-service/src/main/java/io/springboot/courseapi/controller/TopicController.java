package io.springboot.courseapi.controller;

import io.springboot.courseapi.models.Topic;
import io.springboot.courseapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/getAllTopics")
     public ResponseEntity<List<Topic>> getAllTopics(){
        HttpStatus httpStatus;

        List<Topic> topics= null;
        try {
            topics = topicService.getAllTopics();
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return new ResponseEntity<>(topics, httpStatus);
     }

     @GetMapping("{topicId}")
     public ResponseEntity<Topic> getTopic(@PathVariable("topicId") String topicId){
        HttpStatus httpStatus;
         Topic topic = null;
         try {
             topic = topicService.getTopic(topicId);
             httpStatus = HttpStatus.OK;
         } catch (Exception e) {
             e.printStackTrace();
             httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
         }
         return new ResponseEntity<>(topic,httpStatus);
     }

     @PostMapping
     public ResponseEntity<Topic> addTopic(@RequestBody Topic topic){
            HttpStatus httpStatus;
         try {
             topicService.addTopic(topic);
             httpStatus = HttpStatus.CREATED;
         } catch (Exception e) {
             e.printStackTrace();
             httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
         }
         return new ResponseEntity<>(topic,httpStatus);
     }

    @PutMapping(value = "/{topicId}")
    public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic,@PathVariable("topicId") String topicId){
        HttpStatus httpStatus;
        try {
            Topic topicRespose = topicService.update(topicId,topic);
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(topic,httpStatus);
    }

    @DeleteMapping(value = "/{topicId}")
    public ResponseEntity<String> deleteTopic(@PathVariable("topicId") String topicId){
        HttpStatus httpStatus;
        String strRespose;
        try {
            topicService.delete(topicId);
            httpStatus = HttpStatus.OK;
            strRespose = "Topic Deleted "+topicId;
        } catch (Exception e) {
            e.printStackTrace();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            strRespose = e.getMessage();
        }
        return new ResponseEntity<>(strRespose,httpStatus);
    }



}
