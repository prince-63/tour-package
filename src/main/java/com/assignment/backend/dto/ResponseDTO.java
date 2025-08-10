package com.assignment.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Generic API Response wrapper")
public class ResponseDTO<T> {

    @Schema(description = "Response message providing additional details", example = "Tour package fetched successfully")
    private String message;

    @Schema(description = "Indicates whether the request was successful", example = "true")
    private boolean status = true;

    @Schema(description = "Response data payload")
    private T data;
}
