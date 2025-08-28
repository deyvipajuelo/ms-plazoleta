package com.pragma.powerup.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    RESTAURANT_NOT_FOUND("No Restaurant was found with that id"),
    NO_DATA_FOUND("No data found for the requested petition"),
    USER_IS_NOT_OWNER("The user does not have the owner role");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}