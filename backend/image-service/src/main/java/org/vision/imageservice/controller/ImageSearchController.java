package org.vision.imageservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.vision.imageservice.dto.ImageSearchResultDto;
import org.vision.imageservice.service.ImageSearchService;

import java.util.List;

@RestController
@RequestMapping("/search")
public class ImageSearchController {

    private final ImageSearchService imageSearchService;

    public ImageSearchController(ImageSearchService imageSearchService) {
        this.imageSearchService = imageSearchService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> search(
            @RequestParam(value = "image", required = false) MultipartFile image,
            @RequestParam(value = "topK", defaultValue = "5") int topK
    ) {

        if (image == null || image.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("image file is required (multipart/form-data)");
        }

        if (topK <= 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("topK must be greater than 0");
        }

        List<ImageSearchResultDto> results =
                imageSearchService.search(image, topK);

        return ResponseEntity.ok(results);
    }
}
