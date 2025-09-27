# Blog Management API

This document outlines the blog management system for the Shodhanayurveda website.

## Features Implemented

### 1. Blog Entity
- **Blog** entity with the following fields:
  - `id` - Primary key
  - `title` - Blog title
  - `slug` - URL-friendly identifier
  - `content` - Blog content (supports rich text)
  - `summary` - Brief description
  - `author` - Author name
  - `imageUrl` - Featured image URL
  - `tags` - Comma-separated tags
  - `published` - Publication status
  - `featured` - Featured blog flag
  - `createdAt`, `updatedAt`, `publishedAt` - Timestamps

### 2. Database Schema
- **blogs** table created with appropriate indexes
- Sample blog data included
- Flyway migrations: `V21__create_blogs_table.sql` and `V22__add_sample_blogs.sql`

### 3. Repository Layer
- **BlogRepo** with comprehensive query methods:
  - Find published blogs
  - Find featured blogs
  - Search functionality
  - Slug-based queries
  - Author-based queries

### 4. Service Layer
- **BlogService** interface and **BlogServiceImpl** implementation
- Separation of public and admin methods
- Automatic slug generation
- Input validation
- Duplicate slug checking

### 5. Controller Layer
- **BlogController** with separated endpoints:

#### Public Endpoints (for end users)
- `GET /api/blogs/public` - Get all published blogs
- `GET /api/blogs/public/featured` - Get featured blogs
- `GET /api/blogs/public/slug/{slug}` - Get published blog by slug
- `GET /api/blogs/public/search?keyword=` - Search published blogs
- `GET /api/blogs/public/author/{author}` - Get published blogs by author

#### Admin Endpoints (for website admin)
- `GET /api/blogs/admin` - Get all blogs (including unpublished)
- `GET /api/blogs/admin/{id}` - Get blog by ID
- `GET /api/blogs/admin/slug/{slug}` - Get blog by slug (including unpublished)
- `POST /api/blogs/admin` - Create new blog
- `PUT /api/blogs/admin/{id}` - Update existing blog
- `DELETE /api/blogs/admin/{id}` - Delete blog
- `GET /api/blogs/admin/search?keyword=` - Search all blogs
- `GET /api/blogs/admin/generate-slug?title=` - Generate slug from title
- `GET /api/blogs/admin/check-slug?slug=&excludeId=` - Check slug availability

### 6. DTOs
- **BlogDto** for data transfer in admin operations

## Usage Examples

### Creating a Blog (Admin)
```json
POST /api/blogs/admin
{
  "title": "New Blog Post",
  "slug": "new-blog-post",
  "content": "This is the blog content...",
  "summary": "Brief summary",
  "author": "Dr. Author Name",
  "imageUrl": "https://example.com/image.jpg",
  "tags": "ayurveda, health, wellness",
  "published": true,
  "featured": false
}
```

### Updating a Blog (Admin)
```json
PUT /api/blogs/admin/1
{
  "title": "Updated Blog Post",
  "slug": "updated-blog-post",
  "content": "Updated content...",
  "summary": "Updated summary",
  "author": "Dr. Author Name",
  "imageUrl": "https://example.com/updated-image.jpg",
  "tags": "ayurveda, health, wellness, updated",
  "published": true,
  "featured": true
}
```

### Getting Published Blogs (Public)
```
GET /api/blogs/public
```

## Security Considerations

For production deployment, consider:
1. Adding authentication/authorization for admin endpoints
2. Adding rate limiting
3. Input sanitization for XSS prevention
4. Role-based access control
5. Audit logging for admin operations

## Next Steps

1. Test the API endpoints
2. Add authentication for admin endpoints
3. Add image upload functionality
4. Implement rich text editor support
5. Add SEO metadata fields
6. Add blog categories/tags management
7. Add comments system (if needed)