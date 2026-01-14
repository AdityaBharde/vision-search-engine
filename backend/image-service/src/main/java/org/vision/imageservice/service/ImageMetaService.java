package org.vision.imageservice.service;

import org.vision.imageservice.dto.ImageMetaRequestDto;
import org.vision.imageservice.dto.ImageMetaResponseDto;
import org.vision.imageservice.dto.ImageMetaDetailsResponseDto;

public interface ImageMetaService {

    ImageMetaResponseDto createImageMetadata(ImageMetaRequestDto imageMetaRequestDto);
    ImageMetaDetailsResponseDto getImageById(Long id);
}
