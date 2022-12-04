package com.maatlabs.quizservice.beans;

import lombok.Data;

import java.util.List;

@Data
public class Answer {
    private String id;
    private int correctOption;
    private String explanation; // This should be an object with image links ad text. Like Image objects with metadata
    private List<OptionDetail> optionDetails;

    @Data
    public static class OptionDetail {
        private String optionText;
        private boolean correct;
        private String explanation;
    }
}


