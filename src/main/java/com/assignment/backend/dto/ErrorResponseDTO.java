package com.assignment.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private String apiPath;
    private String errorMessage;
    private Integer errorCode;
    private LocalDateTime errorTime;
}
