package org.vision.imageservice.dto;

import java.util.List;

public class MLResponseDto {

    private int dimension;
    private List<Double> embedding;

    public MLResponseDto() {}

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<Double> getEmbedding() {
        return embedding;
    }

    public void setEmbedding(List<Double> embedding) {
        this.embedding = embedding;
    }
}
