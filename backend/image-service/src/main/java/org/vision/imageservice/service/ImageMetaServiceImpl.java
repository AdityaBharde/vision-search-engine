package org.vision.imageservice.service;

import org.springframework.stereotype.Service;
import org.vision.imageservice.dto.ImageMetaRequestDto;
import org.vision.imageservice.dto.ImageMetaResponseDto;
import org.vision.imageservice.dto.ImageMetaDetailsResponseDto;
import org.vision.imageservice.entity.ImageMeta;
import org.vision.imageservice.exception.ImageNotFoundException;
import org.vision.imageservice.repository.ImageMetaRepository;

import java.time.LocalDateTime;

@Service
public class ImageMetaServiceImpl implements ImageMetaService {

    private final ImageMetaRepository imageMetaRepository;

    public ImageMetaServiceImpl(ImageMetaRepository imageMetaRepository) {
        this.imageMetaRepository = imageMetaRepository;
    }

    @Override
    public ImageMetaResponseDto createImageMetadata(ImageMetaRequestDto imageMetaRequestDto) {

        ImageMeta imageMeta = new ImageMeta();
        imageMeta.setImageName(imageMetaRequestDto.getImageName());
        imageMeta.setImagePath(imageMetaRequestDto.getImagePath());

        LocalDateTime now = LocalDateTime.now();
        imageMeta.setCreatedAt(now);
        imageMeta.setUpdatedAt(now);

        imageMetaRepository.save(imageMeta);

        return new ImageMetaResponseDto(
                true,
                "Image metadata created successfully"
        );
    }

    @Override
    public ImageMetaDetailsResponseDto getImageById(Long id) {

        ImageMeta imageMeta = imageMetaRepository.findById(id)
                .orElseThrow(() ->
                        new ImageNotFoundException("Image not found with id: " + id)
                );

        return new ImageMetaDetailsResponseDto(
                true,
                "Image found",
                imageMeta.getId(),
                imageMeta.getImageName(),
                imageMeta.getImagePath(),
                imageMeta.getCreatedAt(),
                imageMeta.getUpdatedAt()
        );
    }
    @Override
    public void deleteImageById(Long id) {

        ImageMeta imageMeta = imageMetaRepository.findById(id)
                .orElseThrow(() ->
                        new ImageNotFoundException("Image not found with id: " + id)
                );

        imageMetaRepository.delete(imageMeta);
    }
}
