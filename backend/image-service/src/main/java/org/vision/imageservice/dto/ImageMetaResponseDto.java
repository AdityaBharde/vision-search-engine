package org.vision.imageservice.dto;

public class ImageMetaResponseDto {

    private boolean success;
    private String message;

    public ImageMetaResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
