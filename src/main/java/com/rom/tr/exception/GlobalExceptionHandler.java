package com.rom.tr.exception;

import com.rom.tr.dto.ApiError;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ApiError> handleException(DuplicateKeyException e) {
        return new ResponseEntity<>(new ApiError("Duplicate Submission", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleException(UsernameNotFoundException e) {
        return new ResponseEntity<>(new ApiError(e.getMessage(), "Please enter correct field"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ApiError> handleException(BadCredentialsException e) {
        return new ResponseEntity<>(new ApiError(e.getMessage(), e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
