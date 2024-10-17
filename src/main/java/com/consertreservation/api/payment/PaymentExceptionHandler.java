package com.consertreservation.api.payment;

import com.consertreservation.domain.user.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PaymentExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<String> handleSeatException(UserException e) {
        return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
    }
}
