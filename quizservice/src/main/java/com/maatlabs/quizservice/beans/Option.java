package com.maatlabs.quizservice.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Option {
    private final int optionNumber;
    private final String text;
}
