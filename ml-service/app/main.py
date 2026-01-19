from fastapi import FastAPI, UploadFile, File, HTTPException
from app.embedding import generate_embedding
import tempfile
import os

app = FastAPI()


@app.get("/")
def root():
    return {"message": "ML service running"}


@app.post("/embed")
async def embed_image(image: UploadFile = File(...)):
    if not image.content_type.startswith("image/"):
        raise HTTPException(status_code=400, detail="Invalid file type")

    try:
        with tempfile.NamedTemporaryFile(delete=False) as temp_file:
            temp_file.write(await image.read())
            temp_path = temp_file.name

        embedding = generate_embedding(temp_path)
        embedding_list = embedding.tolist()

        return {
            "dimension": len(embedding_list),
            "embedding": embedding_list
        }

    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))

    finally:
        if "temp_path" in locals() and os.path.exists(temp_path):
            os.remove(temp_path)
