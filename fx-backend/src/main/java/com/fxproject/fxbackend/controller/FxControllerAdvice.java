package com.fxproject.fxbackend.controller;

import com.fxproject.fxbackend.service.ErrorResponseDto;
import com.fxproject.fxbackend.service.FxCreationException;
import com.fxproject.fxbackend.service.FxUpdateException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FxControllerAdvice {
    @ExceptionHandler(FxCreationException.class)
    public ResponseEntity<ErrorResponseDto> handleCreationException(FxCreationException ex) {
        return ResponseEntity.status(400).body(new ErrorResponseDto(ex.getMessage()));
    }

    @ExceptionHandler(FxUpdateException.class)
    public ResponseEntity<ErrorResponseDto> handleUpdateException(FxUpdateException ex) {
        return ResponseEntity.status(400).body(new ErrorResponseDto(ex.getMessage()));
    }
}
