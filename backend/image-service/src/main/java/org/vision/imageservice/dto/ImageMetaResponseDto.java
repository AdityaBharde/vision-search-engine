package org.vision.imageservice.dto;

import java.io.Serializable;

public class ImageMetaResponseDto implements Serializable {

    private final boolean success;
    private final String message;

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
