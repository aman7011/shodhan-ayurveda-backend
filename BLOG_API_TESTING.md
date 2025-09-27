# Test Blog API Endpoints

## Sample Blog API Test Commands

### 1. Test getting all published blogs (Public endpoint)
```bash
curl -X GET "http://localhost:8080/api/blogs/public"
```

### 2. Test getting featured blogs (Public endpoint)
```bash
curl -X GET "http://localhost:8080/api/blogs/public/featured"
```

### 3. Test getting blog by slug (Public endpoint)
```bash
curl -X GET "http://localhost:8080/api/blogs/public/slug/acne-causes-signs-ayurvedic-treatment"
```

### 4. Test searching published blogs (Public endpoint)
```bash
curl -X GET "http://localhost:8080/api/blogs/public/search?keyword=acne"
```

### 5. Test getting all blogs (Admin endpoint)
```bash
curl -X GET "http://localhost:8080/api/blogs/admin"
```

### 6. Test creating a new blog (Admin endpoint)
```bash
curl -X POST "http://localhost:8080/api/blogs/admin" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "New Test Blog",
    "slug": "new-test-blog",
    "content": "This is a test blog content with some information about Ayurveda.",
    "summary": "A test blog for API testing",
    "author": "Test Author",
    "imageUrl": "https://example.com/test-image.jpg",
    "tags": "test, ayurveda, blog",
    "published": true,
    "featured": false
  }'
```

### 7. Test updating a blog (Admin endpoint) - Replace {id} with actual blog ID
```bash
curl -X PUT "http://localhost:8080/api/blogs/admin/1" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated Test Blog",
    "slug": "updated-test-blog",
    "content": "This is updated blog content.",
    "summary": "Updated test blog",
    "author": "Updated Author",
    "imageUrl": "https://example.com/updated-image.jpg",
    "tags": "updated, test, ayurveda",
    "published": true,
    "featured": true
  }'
```

### 8. Test deleting a blog (Admin endpoint) - Replace {id} with actual blog ID
```bash
curl -X DELETE "http://localhost:8080/api/blogs/admin/3"
```

### 9. Test slug generation utility (Admin endpoint)
```bash
curl -X GET "http://localhost:8080/api/blogs/admin/generate-slug?title=My%20New%20Blog%20Title"
```

### 10. Test slug availability check (Admin endpoint)
```bash
curl -X GET "http://localhost:8080/api/blogs/admin/check-slug?slug=my-new-blog-title"
```

## Expected Responses

### Success Response for Blog Creation:
```json
{
  "id": 3,
  "title": "New Test Blog",
  "slug": "new-test-blog",
  "content": "This is a test blog content...",
  "summary": "A test blog for API testing",
  "author": "Test Author",
  "imageUrl": "https://example.com/test-image.jpg",
  "tags": "test, ayurveda, blog",
  "published": true,
  "featured": false,
  "createdAt": "2025-09-27T10:30:00",
  "updatedAt": "2025-09-27T10:30:00",
  "publishedAt": "2025-09-27T10:30:00"
}
```

### Success Response for Published Blogs List:
```json
[
  {
    "id": 1,
    "title": "Acne: Causes, Signs and Ayurvedic Treatment",
    "slug": "acne-causes-signs-ayurvedic-treatment",
    "content": "# Understanding Acne Through Ayurvedic Lens...",
    "summary": "Learn about acne causes, signs, and effective Ayurvedic treatments...",
    "author": "Dr. Axico",
    "imageUrl": "https://images.unsplash.com/photo-1556228578-8c89e6adf883...",
    "tags": "acne, skin care, ayurveda, natural treatment, herbal medicine",
    "published": true,
    "featured": true,
    "createdAt": "2025-09-20T10:30:00",
    "updatedAt": "2025-09-20T10:30:00",
    "publishedAt": "2025-09-20T10:30:00"
  },
  {
    "id": 2,
    "title": "Gout: Understanding Causes, Early Signs & Ayurvedic Treatment",
    "slug": "gout-causes-early-signs-ayurvedic-treatment",
    "content": "# Gout: An Ayurvedic Perspective on Causes, Signs, and Treatment...",
    "summary": "Comprehensive guide to understanding gout through Ayurveda...",
    "author": "Dr. Axico",
    "imageUrl": "https://images.unsplash.com/photo-1559757148-5c350d0d3c56...",
    "tags": "gout, vatarakta, joint pain, ayurveda, natural treatment",
    "published": true,
    "featured": false,
    "createdAt": "2025-09-22T10:30:00",
    "updatedAt": "2025-09-22T10:30:00",
    "publishedAt": "2025-09-22T10:30:00"
  }
]
```

## Notes:
- Replace `localhost:8080` with your actual server URL if different
- Admin endpoints should have authentication in production
- All timestamps are in ISO format
- Blog content supports Markdown formatting
- Images should be hosted externally and referenced by URL