package org.vision.imageservice.dto;

public class ImageSearchResultDto {

    private Long imageId;
    private String imageName;
    private double similarity;

    public ImageSearchResultDto(Long imageId, String imageName, double similarity) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.similarity = similarity;
    }

    public Long getImageId() {
        return imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public double getSimilarity() {
        return similarity;
    }
}
