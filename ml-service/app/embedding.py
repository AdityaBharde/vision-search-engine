import torch
from PIL import Image
from torchvision import transforms
from app.model import model

preprocess = transforms.Compose([
    transforms.Resize((224, 224)),
    transforms.ToTensor(),
    transforms.Normalize(
        mean=[0.485, 0.456, 0.406],
        std=[0.229, 0.224, 0.225]
    )
])

def generate_embedding(image_path: str):
    """
    Takes image file path and returns 2048-dim embedding vector.
    """

    image = Image.open(image_path).convert("RGB")

    input_tensor = preprocess(image)

    input_tensor = input_tensor.unsqueeze(0)

    with torch.no_grad():
        embedding = model(input_tensor)

    embedding = embedding.squeeze(0)

    return embedding
