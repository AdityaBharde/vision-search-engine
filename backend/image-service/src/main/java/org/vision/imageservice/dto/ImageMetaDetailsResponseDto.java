package org.vision.imageservice.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ImageMetaDetailsResponseDto {

    private boolean success;
    private String message;
    private Long id;
    private String imageName;
    private String imagePath;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ImageMetaDetailsResponseDto(
            boolean success,
            String message,
            Long id,
            String imageName,
            String imagePath,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.success = success;
        this.message = message;
        this.id = id;
        this.imageName = imageName;
        this.imagePath = imagePath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
