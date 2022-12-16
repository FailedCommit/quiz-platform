package com.maatlabs.quizservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
@EnableMongoRepositories//(basePackages = "com.maatlabs.quizservice.beans")
public class QuizserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizserviceApplication.class, args);
    }
}
