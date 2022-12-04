package com.maatlabs.quizservice;

import com.maatlabs.quizservice.repos.QuizRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.support.SimpleMongoRepository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import static java.lang.System.getenv;

@SpringBootApplication
@EnableMongoRepositories//(basePackages = "com.maatlabs.quizservice.beans")
public class QuizserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizserviceApplication.class, args);
    }
}
