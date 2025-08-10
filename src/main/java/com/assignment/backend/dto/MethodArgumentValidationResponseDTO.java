package com.assignment.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
public class MethodArgumentValidationResponseDTO extends ErrorResponseDTO {
    private Map<String, String> validationErrors;

    public MethodArgumentValidationResponseDTO(
            String apiPath, String errorMessage, Integer errorCode, LocalDateTime errorTime, Map<String, String> validationErrors
    ) {
        super(apiPath, errorMessage, errorCode, errorTime);
        this.validationErrors = validationErrors;
    }
}
