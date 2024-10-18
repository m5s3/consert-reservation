package com.consertreservation.api.usertoken;

import com.consertreservation.domain.usertoken.exception.UserTokenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserTokenExceptionHandler {

    @ExceptionHandler(UserTokenException.class)
    public ResponseEntity<String> handleSeatException(UserTokenException e) {
        return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
    }
}
