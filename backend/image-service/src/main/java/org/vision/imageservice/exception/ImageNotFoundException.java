package org.vision.imageservice.exception;


public class ImageNotFoundException extends RuntimeException{
    public ImageNotFoundException(String message) {
        super(message);
    }
    public ImageNotFoundException() {
        super();
    }
}
