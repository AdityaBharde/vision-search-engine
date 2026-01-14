package org.vision.imageservice.dto;


public class ErrorResponse {
    private String message;
    private boolean success;

    public ErrorResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public boolean isSuccess() {
        return success;
    }

}
