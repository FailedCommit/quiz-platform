package com.maatlabs.quizservice.beans.dtos;

import lombok.Data;

import java.util.Map;

@Data
public class PIIActionResponse {
    private String requestId;
    private String responderId;
    private String status;
    private Map<String, String> changelog;
}
