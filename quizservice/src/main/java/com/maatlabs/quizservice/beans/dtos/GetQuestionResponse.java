package com.maatlabs.quizservice.beans.dtos;

import com.maatlabs.quizservice.beans.Option;
import com.maatlabs.quizservice.beans.Question;
import lombok.Data;

import java.util.List;

@Data
public class GetQuestionResponse {
    private Question question;
    private List<Option> options;
}
