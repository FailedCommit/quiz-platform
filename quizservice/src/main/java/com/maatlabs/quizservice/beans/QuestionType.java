package com.maatlabs.quizservice.beans;

public enum QuestionType {
    TRUE_FALSE,
    MULTIPLE_CHOICE,
    // More than one correct answers to be selected
    MULTIPLE_ANSWER,
    // User needs to provide detailed answer by typing one or more sentences of text.
    DESCRIPTIVE;
}
