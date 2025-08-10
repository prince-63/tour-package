package com.assignment.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Standard API error response format")
public class ErrorResponseDTO {

    @Schema(description = "The API path where the error occurred", example = "/api/v1/tour-packages/10")
    private String apiPath;

    @Schema(description = "Detailed error message explaining the cause", example = "Tour package with ID 10 not found")
    private String errorMessage;

    @Schema(description = "HTTP status code of the error", example = "404")
    private Integer errorCode;

    @Schema(description = "Timestamp when the error occurred", example = "2025-08-10T14:30:15")
    private LocalDateTime errorTime;
}
