package org.vision.imageservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class ImageMetaRequestDto implements Serializable {

    @NotBlank(message = "Image name must not be blank")
    @Size(max = 255, message = "Image name must not exceed 255 characters")
    private String imageName;

    @NotBlank(message = "Image path must not be blank")
    @Size(max = 2048, message = "Image path must not exceed 2048 characters")
    private String imagePath;

    public ImageMetaRequestDto() {
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
