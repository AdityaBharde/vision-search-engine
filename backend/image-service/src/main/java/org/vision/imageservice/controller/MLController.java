package org.vision.imageservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.vision.imageservice.dto.MLResponseDto;
import org.vision.imageservice.service.MLInferenceService;

@RestController
@RequestMapping("/ml/test")
public class MLController {

    private final MLInferenceService mlInferenceService;

    public MLController(MLInferenceService mlInferenceService) {
        this.mlInferenceService = mlInferenceService;
    }

    @PostMapping("/embed")
    public ResponseEntity<MLResponseDto> testEmbedding(
            @RequestParam("image") MultipartFile image
    ) {
        if (image.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        MLResponseDto response =
                mlInferenceService.generateAndStoreEmbedding(image);
        return ResponseEntity.ok(response);
    }
}
