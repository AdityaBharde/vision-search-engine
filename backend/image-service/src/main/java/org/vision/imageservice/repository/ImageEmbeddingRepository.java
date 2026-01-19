package org.vision.imageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vision.imageservice.entity.ImageEmbedding;

public interface ImageEmbeddingRepository extends JpaRepository<ImageEmbedding, Long> {
}
