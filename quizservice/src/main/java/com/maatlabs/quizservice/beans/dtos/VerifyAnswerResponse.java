package com.maatlabs.quizservice.beans.dtos;

import lombok.Data;

@Data
public class VerifyAnswerResponse {
    private boolean correctAnswer;
    private String explanation;
}
