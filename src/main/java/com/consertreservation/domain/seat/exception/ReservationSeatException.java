package com.consertreservation.domain.seat.exception;

public class ReservationSeatException extends RuntimeException {

    private final ReservationErrorCode errorCode;
    private final String message;

    public ReservationSeatException(ReservationErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
