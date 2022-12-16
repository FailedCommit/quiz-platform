package com.maatlabs.userservice.beans.dtos;

import com.maatlabs.userservice.beans.enums.PIIAction;
import lombok.Data;

import java.util.Set;

@Data
public class PIIActionRequest {
    private String requestId;
    private PIIAction piiAction;
    private Set<String> actionableFields;
}
