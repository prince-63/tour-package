package com.assignment.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Validation error response with detailed field-level messages")
public class MethodArgumentValidationResponseDTO extends ErrorResponseDTO {

    @Schema(description = "Map of field names to validation error messages",
            example = "{\"title\": \"Title should not be empty!\", \"actualPrice\": \"Price should not be null!\"}")
    private Map<String, String> validationErrors;

    public MethodArgumentValidationResponseDTO(
            String apiPath,
            String errorMessage,
            Integer errorCode,
            LocalDateTime errorTime,
            Map<String, String> validationErrors
    ) {
        super(apiPath, errorMessage, errorCode, errorTime);
        this.validationErrors = validationErrors;
    }
}
