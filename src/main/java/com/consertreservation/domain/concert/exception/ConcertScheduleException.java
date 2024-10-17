package com.consertreservation.domain.concert.exception;

public class ConcertScheduleException extends RuntimeException {
    private final ConcertScheduleErrorCode errorCode;
    private final String message;

    public ConcertScheduleException(ConcertScheduleErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
