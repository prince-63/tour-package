package com.assignment.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TourPackageNotFoundException extends RuntimeException {
    public TourPackageNotFoundException(Long id) {
        super(String.format("Tour Package with provided id: %d not found!", id));
    }
}
