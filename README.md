#  Vision Search Engine

A **visual similarity search system** that allows users to index images, generate embeddings using an ML service, and search for visually similar images using a backend API.

The project follows a **microservice-style architecture**, separating image metadata management, embedding generation, and similarity search.

---

##  Features

-  Visual similarity search using image embeddings  
-  ML-powered embedding generation (Python + FastAPI)  
-  Image metadata CRUD APIs  
-  Fast & scalable backend using Spring Boot  
-  Clean separation between backend and ML services  

---

##  Architecture Overview

```
Client
  │
  ▼
Spring Boot Backend (Image Service)
  │
  ├── Image Metadata Management (CRUD)
  ├── Similarity Search API
  │
  ▼
Python ML Service (FastAPI)
  └── Image Embedding Generation
```

---

##  API Usage

The backend runs by default on:

```
http://localhost:8080
```

---

### 1️. Search for Similar Images

Upload an image and retrieve the most visually similar images from the database.

**Endpoint**
```
POST /search
```

**Request**
- Content-Type: `multipart/form-data`

| Field | Type | Required | Description |
|------|------|----------|-------------|
| image | File | ✅ | Image to search |
| topK | Integer | ❌ | Number of results (default: 5) |

---

### 2️. Add / Index an Image

Generate an embedding for an image and store it for future similarity searches.

**Endpoint**
```
POST /ml/test/embed
```

**Request**
- Content-Type: `multipart/form-data`

| Field | Type | Required | Description |
|------|------|----------|-------------|
| image | File | ✅ | Image to index |

---

### 3. Image Metadata Management

CRUD APIs for managing image metadata.

| Operation | Endpoint |
|----------|----------|
| Create Metadata | `POST /images` |
| Get Metadata | `GET /images/{id}` |
| Update Metadata | `PUT /images/{id}` |
| Delete Metadata | `DELETE /images/{id}` |

---

##  Project Structure

```
vision-search-engine/
├── backend/
│   └── image-service/          # Spring Boot backend
│       ├── src/                # Java source code
│       └── pom.xml             # Maven dependencies
│
├── ml-service/                 # Python ML service
│   ├── app/                    # FastAPI app & model logic
│   └── requirements.txt        # Python dependencies
│
└── README.md
```

---

## 🛠️ Tech Stack

### Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL (or compatible database)

### ML Service
- Python
- FastAPI
- Deep learning model for image embeddings

---

##  Use Cases

- Image search engines  
- E-commerce product similarity  
- Duplicate image detection  
- Visual recommendation systems  

---

##  Notes

- Backend and ML services are fully decoupled for independent scaling.
- Designed with production-grade separation of concerns.
- Can be extended to support vector databases (FAISS, Milvus, Pinecone, etc.).

---
