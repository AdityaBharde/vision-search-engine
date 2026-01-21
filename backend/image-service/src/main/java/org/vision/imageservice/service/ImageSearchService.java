package org.vision.imageservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.vision.imageservice.client.MLServiceClient;
import org.vision.imageservice.dto.ImageSearchResultDto;
import org.vision.imageservice.dto.MLResponseDto;
import org.vision.imageservice.entity.ImageEmbedding;
import org.vision.imageservice.repository.ImageEmbeddingRepository;
import org.vision.imageservice.util.CosineSimilarityUtil;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageSearchService {

    private final MLServiceClient mlServiceClient;
    private final ImageEmbeddingRepository imageEmbeddingRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ImageSearchService(
            MLServiceClient mlServiceClient,
            ImageEmbeddingRepository imageEmbeddingRepository
    ) {
        this.mlServiceClient = mlServiceClient;
        this.imageEmbeddingRepository = imageEmbeddingRepository;
    }

    public List<ImageSearchResultDto> search(MultipartFile image, int topK) {

        try {

            MLResponseDto queryEmbedding = mlServiceClient.getEmbedding(
                    image.getBytes(),
                    image.getOriginalFilename()
            );

            String vectorString = queryEmbedding.getEmbedding().toString();

            List<ImageEmbedding> results = imageEmbeddingRepository.findNearestNeighbors(vectorString, topK);

            return results.stream().map(e -> new ImageSearchResultDto(
                    e.getImageMeta().getId(),
                    e.getImageMeta().getImageName(),
                    0.0 // Score calculation is now done by DB
            )).collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException("Search failed", e);
        }
    }
}
