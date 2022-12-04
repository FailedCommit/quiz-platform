package com.maatlabs.quizservice.repos;

import com.maatlabs.quizservice.beans.QuizItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends MongoRepository<QuizItem, String> {
}
