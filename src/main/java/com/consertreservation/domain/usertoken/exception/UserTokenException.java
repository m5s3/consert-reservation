package com.consertreservation.domain.usertoken.exception;

public class UserTokenException extends RuntimeException {

    private final UserTokenErrorCode errorCode;
    private final String message;

    public UserTokenException(UserTokenErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "[%s] %s".formatted(errorCode, message);
    }
}
