from app.embedding import generate_embedding

embedding = generate_embedding("test_image.jpeg")
print(embedding.shape)
