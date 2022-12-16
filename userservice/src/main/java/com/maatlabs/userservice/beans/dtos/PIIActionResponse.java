package com.maatlabs.userservice.beans.dtos;

import com.maatlabs.userservice.beans.enums.PIIAction;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
public class PIIActionResponse {
    private String requestId;
    private String responderId;
    private String status;
    private Map<String, String> changelog;
}
