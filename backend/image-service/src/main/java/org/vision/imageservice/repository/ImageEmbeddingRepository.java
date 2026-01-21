package org.vision.imageservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.vision.imageservice.entity.ImageEmbedding;
import java.util.List;

public interface ImageEmbeddingRepository extends JpaRepository<ImageEmbedding, Long> {
    @Query(value = "SELECT * FROM image_embedding ORDER BY embedding_vector <-> cast(:queryVector as vector) LIMIT :limit", nativeQuery = true)
    List<ImageEmbedding> findNearestNeighbors(@Param("queryVector") String queryVector, @Param("limit") int limit);
}
