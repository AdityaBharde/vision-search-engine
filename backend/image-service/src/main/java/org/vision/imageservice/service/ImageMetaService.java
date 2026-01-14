package org.vision.imageservice.service;

import org.vision.imageservice.dto.ImageMetaRequestDto;
import org.vision.imageservice.dto.ImageMetaResponseDto;

public interface ImageMetaService {
    ImageMetaResponseDto createImageMetadata(ImageMetaRequestDto imageMetaRequestDto);
}

