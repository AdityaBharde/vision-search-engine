package org.vision.imageservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "image_embedding")
public class ImageEmbedding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "image_id", nullable = false)
    private ImageMeta imageMeta;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String embeddingJson;

    public ImageEmbedding() {}

    public ImageEmbedding(ImageMeta imageMeta, String embeddingJson) {
        this.imageMeta = imageMeta;
        this.embeddingJson = embeddingJson;
    }

    public Long getId() {
        return id;
    }

    public ImageMeta getImageMeta() {
        return imageMeta;
    }

    public String getEmbeddingJson() {
        return embeddingJson;
    }
}
