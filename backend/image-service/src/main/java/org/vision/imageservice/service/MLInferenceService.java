package org.vision.imageservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.vision.imageservice.client.MLServiceClient;
import org.vision.imageservice.dto.MLResponseDto;
import org.vision.imageservice.entity.ImageEmbedding;
import org.vision.imageservice.entity.ImageMeta;
import org.vision.imageservice.repository.ImageEmbeddingRepository;
import org.vision.imageservice.repository.ImageMetaRepository;

import java.time.LocalDateTime;

@Service
public class MLInferenceService {

    private final MLServiceClient mlServiceClient;
    private final ImageMetaRepository imageMetaRepository;
    private final ImageEmbeddingRepository imageEmbeddingRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public MLInferenceService(
            MLServiceClient mlServiceClient,
            ImageMetaRepository imageMetaRepository,
            ImageEmbeddingRepository imageEmbeddingRepository
    ) {
        this.mlServiceClient = mlServiceClient;
        this.imageMetaRepository = imageMetaRepository;
        this.imageEmbeddingRepository = imageEmbeddingRepository;
    }

    public MLResponseDto generateAndStoreEmbedding(MultipartFile image) {
        try {

            MLResponseDto mlResponse = mlServiceClient.getEmbedding(
                    image.getBytes(),
                    image.getOriginalFilename()
            );


            ImageMeta imageMeta = new ImageMeta();
            imageMeta.setImageName(image.getOriginalFilename());
            imageMeta.setImagePath("N/A");

            LocalDateTime now = LocalDateTime.now();
            imageMeta.setCreatedAt(now);
            imageMeta.setUpdatedAt(now);

            imageMeta = imageMetaRepository.save(imageMeta);


            return mlResponse;

        } catch (Exception e) {
            throw new RuntimeException("Failed to generate/store embedding", e);
        }
    }
}
