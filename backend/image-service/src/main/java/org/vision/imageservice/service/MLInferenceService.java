package org.vision.imageservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.vision.imageservice.client.MLServiceClient;
import org.vision.imageservice.dto.MLResponseDto;

@Service
public class MLInferenceService {

    private final MLServiceClient mlServiceClient;

    public MLInferenceService(MLServiceClient mlServiceClient) {
        this.mlServiceClient = mlServiceClient;
    }

    public MLResponseDto generateEmbedding(MultipartFile image) {
        try {
            return mlServiceClient.getEmbedding(
                    image.getBytes(),
                    image.getOriginalFilename()
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to call ML service", e);
        }
    }
}
