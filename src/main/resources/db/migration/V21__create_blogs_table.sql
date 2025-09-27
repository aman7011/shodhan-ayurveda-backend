CREATE TABLE blogs (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    slug VARCHAR(255) NOT NULL UNIQUE,
    content TEXT NOT NULL,
    summary VARCHAR(500),
    author VARCHAR(100) NOT NULL,
    image_url VARCHAR(1000),
    tags VARCHAR(500),
    published BOOLEAN DEFAULT FALSE,
    featured BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    published_at TIMESTAMP
);

-- Create index for better performance
CREATE INDEX idx_blogs_published ON blogs(published);
CREATE INDEX idx_blogs_featured ON blogs(featured);
CREATE INDEX idx_blogs_slug ON blogs(slug);
CREATE INDEX idx_blogs_created_at ON blogs(created_at DESC);