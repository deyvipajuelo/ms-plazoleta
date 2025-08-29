package com.pragma.powerup.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    RESTAURANT_NOT_FOUND("No Restaurant was found with that id"),
    NO_DATA_FOUND("No data found for the requested petition"),
    USER_IS_NOT_OWNER("The user does not have the owner role"),
    EXTERNAL_INVALID_REQUEST("The external request is invalid"),
    EXTERNAL_RESOURCE_NOT_FOUND("The external resource was not found"),
    EXTERNAL_SERVICE_ERROR("There was an error communicating with an external service");

    private String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}