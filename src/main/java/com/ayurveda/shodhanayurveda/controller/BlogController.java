package com.ayurveda.shodhanayurveda.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayurveda.shodhanayurveda.dto.BlogDto;
import com.ayurveda.shodhanayurveda.entity.Blog;
import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.services.BlogService;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "http://localhost:5173") // allow frontend
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    // Public endpoints (for end users)

    @GetMapping("/public")
    public ResponseEntity<List<Blog>> getPublishedBlogs() {
        List<Blog> blogs = blogService.getAllPublishedBlogs();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/public/featured")
    public ResponseEntity<List<Blog>> getFeaturedBlogs() {
        List<Blog> blogs = blogService.getFeaturedBlogs();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/public/slug/{slug}")
    public ResponseEntity<Blog> getPublishedBlogBySlug(@PathVariable String slug) {
        Blog blog = blogService.getPublishedBlogBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Published blog not found with slug: " + slug));
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/public/search")
    public ResponseEntity<List<Blog>> searchPublishedBlogs(@RequestParam String keyword) {
        List<Blog> blogs = blogService.searchPublishedBlogs(keyword);
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/public/author/{author}")
    public ResponseEntity<List<Blog>> getPublishedBlogsByAuthor(@PathVariable String author) {
        List<Blog> blogs = blogService.getPublishedBlogsByAuthor(author);
        return ResponseEntity.ok(blogs);
    }

    // Admin endpoints (for website admin)

    @GetMapping("/admin")
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = blogService.getAllBlogs();
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
        Blog blog = blogService.getBlogById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
        return ResponseEntity.ok(blog);
    }

    @GetMapping("/admin/slug/{slug}")
    public ResponseEntity<Blog> getBlogBySlug(@PathVariable String slug) {
        Blog blog = blogService.getBlogBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with slug: " + slug));
        return ResponseEntity.ok(blog);
    }

    @PostMapping("/admin")
    public ResponseEntity<Blog> createBlog(@RequestBody BlogDto blogDto) {
        try {
            Blog createdBlog = blogService.createBlog(blogDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBlog);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody BlogDto blogDto) {
        try {
            Blog updatedBlog = blogService.updateBlog(id, blogDto);
            return ResponseEntity.ok(updatedBlog);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
        try {
            blogService.deleteBlog(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/admin/search")
    public ResponseEntity<List<Blog>> searchAllBlogs(@RequestParam String keyword) {
        List<Blog> blogs = blogService.searchAllBlogs(keyword);
        return ResponseEntity.ok(blogs);
    }

    // Utility endpoints for admin

    @GetMapping("/admin/generate-slug")
    public ResponseEntity<String> generateSlug(@RequestParam String title) {
        String slug = blogService.generateSlug(title);
        return ResponseEntity.ok(slug);
    }

    @GetMapping("/admin/check-slug")
    public ResponseEntity<Boolean> checkSlugAvailability(@RequestParam String slug, 
                                                        @RequestParam(required = false) Long excludeId) {
        boolean available = excludeId != null ? 
                blogService.isSlugAvailable(slug, excludeId) : 
                blogService.isSlugAvailable(slug);
        return ResponseEntity.ok(available);
    }
}