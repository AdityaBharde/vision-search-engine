package org.vision.imageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vision.imageservice.entity.ImageMeta;

public interface ImageMetaRepository extends JpaRepository<ImageMeta, Long> {
}
