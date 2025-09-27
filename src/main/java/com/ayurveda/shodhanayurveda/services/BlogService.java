package com.ayurveda.shodhanayurveda.services;

import java.util.List;
import java.util.Optional;

import com.ayurveda.shodhanayurveda.dto.BlogDto;
import com.ayurveda.shodhanayurveda.entity.Blog;

public interface BlogService {
    
    // Public endpoints (for end users)
    List<Blog> getAllPublishedBlogs();
    List<Blog> getFeaturedBlogs();
    Optional<Blog> getPublishedBlogBySlug(String slug);
    List<Blog> searchPublishedBlogs(String keyword);
    List<Blog> getPublishedBlogsByAuthor(String author);
    
    // Admin endpoints (for website admin)
    List<Blog> getAllBlogs();
    Optional<Blog> getBlogById(Long id);
    Optional<Blog> getBlogBySlug(String slug);
    Blog createBlog(BlogDto blogDto);
    Blog updateBlog(Long id, BlogDto blogDto);
    void deleteBlog(Long id);
    List<Blog> searchAllBlogs(String keyword);
    
    // Utility methods
    String generateSlug(String title);
    boolean isSlugAvailable(String slug);
    boolean isSlugAvailable(String slug, Long excludeId);
}