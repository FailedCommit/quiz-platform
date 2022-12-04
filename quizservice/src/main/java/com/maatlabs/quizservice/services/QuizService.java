package com.maatlabs.quizservice.services;

import com.maatlabs.quizservice.beans.QuizItem;
import com.maatlabs.quizservice.beans.dtos.CreateQuizItemRequest;
import com.maatlabs.quizservice.repos.QuizRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepo quizRepo;
    public QuizItem createQuizItem(CreateQuizItemRequest request) {
        return quizRepo.save(request.createQuizItem());
    }

    public QuizItem getQuizItem(String quizItemId) {
        return quizRepo.findById(quizItemId).get();
    }
}
