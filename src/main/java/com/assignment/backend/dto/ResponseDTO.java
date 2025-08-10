package com.assignment.backend.dto;

import lombok.Data;

@Data
public class ResponseDTO <T> {
    public String message;
    public boolean status = true;
    public T data;
}
