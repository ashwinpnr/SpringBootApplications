package io.springboot.courseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CourseAPIApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseAPIApplication.class,args);
    }
}
