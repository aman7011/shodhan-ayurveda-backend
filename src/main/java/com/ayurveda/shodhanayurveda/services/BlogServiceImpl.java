package com.ayurveda.shodhanayurveda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayurveda.shodhanayurveda.dto.BlogDto;
import com.ayurveda.shodhanayurveda.entity.Blog;
import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.repository.BlogRepo;

@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepo blogRepo;

    public BlogServiceImpl(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    // Public endpoints (for end users)
    @Override
    public List<Blog> getAllPublishedBlogs() {
        return blogRepo.findPublishedBlogsOrderByCreatedAtDesc();
    }

    @Override
    public List<Blog> getFeaturedBlogs() {
        return blogRepo.findFeaturedBlogs();
    }

    @Override
    public Optional<Blog> getPublishedBlogBySlug(String slug) {
        return blogRepo.findPublishedBySlug(slug);
    }

    @Override
    public List<Blog> searchPublishedBlogs(String keyword) {
        return blogRepo.searchPublishedBlogs(keyword);
    }

    @Override
    public List<Blog> getPublishedBlogsByAuthor(String author) {
        return blogRepo.findPublishedByAuthor(author);
    }

    // Admin endpoints (for website admin)
    @Override
    public List<Blog> getAllBlogs() {
        return blogRepo.findAll();
    }

    @Override
    public Optional<Blog> getBlogById(Long id) {
        return blogRepo.findById(id);
    }

    @Override
    public Optional<Blog> getBlogBySlug(String slug) {
        return blogRepo.findBySlug(slug);
    }

    @Override
    public Blog createBlog(BlogDto blogDto) {
        // Validate required fields
        if (blogDto.getTitle() == null || blogDto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (blogDto.getContent() == null || blogDto.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Content is required");
        }
        if (blogDto.getAuthor() == null || blogDto.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Author is required");
        }

        // Generate slug if not provided
        String slug = blogDto.getSlug();
        if (slug == null || slug.trim().isEmpty()) {
            slug = generateSlug(blogDto.getTitle());
        }

        // Ensure slug is unique
        if (!isSlugAvailable(slug)) {
            throw new IllegalArgumentException("Slug already exists: " + slug);
        }

        Blog blog = Blog.builder()
                .title(blogDto.getTitle().trim())
                .slug(slug)
                .content(blogDto.getContent().trim())
                .summary(blogDto.getSummary() != null ? blogDto.getSummary().trim() : null)
                .author(blogDto.getAuthor().trim())
                .imageUrl(blogDto.getImageUrl())
                .tags(blogDto.getTags())
                .published(blogDto.getPublished() != null ? blogDto.getPublished() : false)
                .featured(blogDto.getFeatured() != null ? blogDto.getFeatured() : false)
                .build();

        return blogRepo.save(blog);
    }

    @Override
    public Blog updateBlog(Long id, BlogDto blogDto) {
        Blog existingBlog = blogRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));

        // Validate required fields
        if (blogDto.getTitle() == null || blogDto.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Title is required");
        }
        if (blogDto.getContent() == null || blogDto.getContent().trim().isEmpty()) {
            throw new IllegalArgumentException("Content is required");
        }
        if (blogDto.getAuthor() == null || blogDto.getAuthor().trim().isEmpty()) {
            throw new IllegalArgumentException("Author is required");
        }

        // Handle slug
        String slug = blogDto.getSlug();
        if (slug == null || slug.trim().isEmpty()) {
            slug = generateSlug(blogDto.getTitle());
        }

        // Check if slug is available (excluding current blog)
        if (!isSlugAvailable(slug, id)) {
            throw new IllegalArgumentException("Slug already exists: " + slug);
        }

        // Update the blog
        existingBlog.setTitle(blogDto.getTitle().trim());
        existingBlog.setSlug(slug);
        existingBlog.setContent(blogDto.getContent().trim());
        existingBlog.setSummary(blogDto.getSummary() != null ? blogDto.getSummary().trim() : null);
        existingBlog.setAuthor(blogDto.getAuthor().trim());
        existingBlog.setImageUrl(blogDto.getImageUrl());
        existingBlog.setTags(blogDto.getTags());
        existingBlog.setPublished(blogDto.getPublished() != null ? blogDto.getPublished() : false);
        existingBlog.setFeatured(blogDto.getFeatured() != null ? blogDto.getFeatured() : false);

        return blogRepo.save(existingBlog);
    }

    @Override
    public void deleteBlog(Long id) {
        if (!blogRepo.existsById(id)) {
            throw new ResourceNotFoundException("Blog not found with id: " + id);
        }
        blogRepo.deleteById(id);
    }

    @Override
    public List<Blog> searchAllBlogs(String keyword) {
        return blogRepo.searchBlogs(keyword);
    }

    // Utility methods
    @Override
    public String generateSlug(String title) {
        if (title == null || title.trim().isEmpty()) {
            return "";
        }
        
        return title.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")  // Remove special characters except spaces and hyphens
                .replaceAll("\\s+", "-")           // Replace spaces with hyphens
                .replaceAll("-+", "-")             // Replace multiple hyphens with single hyphen
                .replaceAll("^-|-$", "");          // Remove leading/trailing hyphens
    }

    @Override
    public boolean isSlugAvailable(String slug) {
        return !blogRepo.existsBySlug(slug);
    }

    @Override
    public boolean isSlugAvailable(String slug, Long excludeId) {
        return !blogRepo.existsBySlugAndIdNot(slug, excludeId);
    }
}