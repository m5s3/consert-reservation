package com.consertreservation.domain.seat.exception;

public class SeatException extends RuntimeException {

    private final SeatErrorCode errorCode;
    private final String message;

    public SeatException(SeatErrorCode errorCode, String message) {
        this.errorCode =errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
