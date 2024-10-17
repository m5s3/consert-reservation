package com.consertreservation.api.seat;

import com.consertreservation.domain.concert.exception.ConcertScheduleException;
import com.consertreservation.domain.seat.exception.ReservationSeatException;
import com.consertreservation.domain.seat.exception.SeatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SeatExceptionHandler {

    @ExceptionHandler(ConcertScheduleException.class)
    public ResponseEntity<String> handleConcertScheduleException(ConcertScheduleException e) {
        return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
    }

    @ExceptionHandler(SeatException.class)
    public ResponseEntity<String> handleSeatException(SeatException e) {
        return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
    }

    @ExceptionHandler(ReservationSeatException.class)
    public ResponseEntity<String> handleReservationException(ReservationSeatException e) {
        return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
    }
}
