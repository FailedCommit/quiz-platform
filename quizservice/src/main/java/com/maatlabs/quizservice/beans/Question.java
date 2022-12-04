package com.maatlabs.quizservice.beans;

import com.maatlabs.quizservice.beans.enums.Difficulty;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class Question {
    private String text;
    private Difficulty difficulty;
    private QuestionType type;
}
