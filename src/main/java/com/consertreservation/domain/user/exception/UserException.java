package com.consertreservation.domain.user.exception;

public class UserException extends RuntimeException {

    private final UserErrorCode errorCode;
    private final String message;

    public UserException(UserErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
