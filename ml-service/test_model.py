import torch
from app.model import model

dummy_input = torch.randn(1, 3, 224, 224)

with torch.no_grad():
    embedding = model(dummy_input)

print(embedding.shape)
