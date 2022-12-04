package com.maatlabs.quizservice.beans.dtos;

import lombok.Data;

import java.util.List;

@Data
public class VerifyAnswerRequest {
    private String quizItemId;
    private List<Integer> selectedOptions;
}
