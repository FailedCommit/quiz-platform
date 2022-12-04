package com.maatlabs.quizservice.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@RequiredArgsConstructor
@Data
@Document
public class QuizItem {
    @Id
    private String id;
    private final Question question;
    private List<Option> options;
    private final Answer answer;
}

