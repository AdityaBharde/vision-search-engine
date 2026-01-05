package org.vision.imageservice.service;

import org.springframework.stereotype.Service;
import org.vision.imageservice.entity.ImageMeta;
import org.vision.imageservice.repository.ImageMetaRepository;

@Service
public class ImageMetaService {

    private final ImageMetaRepository imageMetaRepository;

    public ImageMetaService(ImageMetaRepository imageMetaRepository) {
        this.imageMetaRepository = imageMetaRepository;
    }

    public ImageMeta save(ImageMeta imageMeta) {
        return imageMetaRepository.save(imageMeta);
    }
}
