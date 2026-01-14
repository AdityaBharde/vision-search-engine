package org.vision.imageservice.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vision.imageservice.dto.ImageMetaDetailsResponseDto;
import org.vision.imageservice.dto.ImageMetaRequestDto;
import org.vision.imageservice.dto.ImageMetaResponseDto;
import org.vision.imageservice.service.ImageMetaService;

@RestController
@RequestMapping("/images")
public class ImageController {

    private final ImageMetaService imageMetaService;

    public ImageController(ImageMetaService imageMetaService) {
        this.imageMetaService = imageMetaService;
    }

    @GetMapping("/health")
    public String health() {
        return "Image Service is UP";
    }

    @PostMapping
    public ResponseEntity<ImageMetaResponseDto> createImage(
            @Valid @RequestBody ImageMetaRequestDto imageMetaRequestDto
    ) {
        ImageMetaResponseDto response =
                imageMetaService.createImageMetadata(imageMetaRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageMetaDetailsResponseDto> getImageById(@PathVariable Long id) {

        ImageMetaDetailsResponseDto response =
                imageMetaService.getImageById(id);

        return ResponseEntity.ok(response);
    }

}
