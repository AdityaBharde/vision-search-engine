import torch
import torch.nn as nn
from torchvision import models

def load_model():
    # Load pretrained ResNet50
    model = models.resnet50(pretrained=True)

    model.fc = nn.Identity()

    model.eval()

    return model

model = load_model()
