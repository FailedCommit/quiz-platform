package com.maatlabs.quizservice.beans.dtos;

import com.maatlabs.quizservice.beans.enums.PIIAction;
import lombok.Data;

import java.util.Set;

@Data
public class PIIActionRequest {
    private String requestId;
    private PIIAction piiAction;
    private Set<String> actionableFields;
}
