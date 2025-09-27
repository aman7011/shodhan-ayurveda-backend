package com.ayurveda.shodhanayurveda.controller;

import com.ayurveda.shodhanayurveda.dto.ApiResponse;
import com.ayurveda.shodhanayurveda.dto.BlogDto;
import com.ayurveda.shodhanayurveda.entity.Blog;
import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.exception.ValidationException;
import com.ayurveda.shodhanayurveda.services.BlogService;
import io.micrometer.core.annotation.Timed;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/blogs")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RequiredArgsConstructor
@Slf4j
@Validated
@Timed("blog.controller")
public class BlogControllerEnhanced {

    private final BlogService blogService;

    // Public endpoints (for end users)

    @GetMapping("/public")
    @Timed("blog.controller.getPublishedBlogs")
    public ResponseEntity<ApiResponse<List<Blog>>> getPublishedBlogs() {
        List<Blog> blogs = blogService.getAllPublishedBlogs();
        log.info("Retrieved {} published blogs", blogs.size());
        
        return ResponseEntity.ok(ApiResponse.success(blogs, 
                String.format("Retrieved %d blogs", blogs.size())));
    }

    @GetMapping("/public/featured")
    @Timed("blog.controller.getFeaturedBlogs")
    public ResponseEntity<ApiResponse<List<Blog>>> getFeaturedBlogs() {
        List<Blog> blogs = blogService.getFeaturedBlogs();
        log.info("Retrieved {} featured blogs", blogs.size());
        
        return ResponseEntity.ok(ApiResponse.success(blogs, "Featured blogs retrieved successfully"));
    }

    @GetMapping("/public/slug/{slug}")
    @Timed("blog.controller.getPublishedBlogBySlug")
    public ResponseEntity<ApiResponse<Blog>> getPublishedBlogBySlug(
            @PathVariable @NotBlank(message = "Slug cannot be blank") String slug) {
        
        Blog blog = blogService.getPublishedBlogBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Published blog not found with slug: " + slug));
        
        log.info("Retrieved published blog with slug: {}", slug);
        return ResponseEntity.ok(ApiResponse.success(blog, "Blog retrieved successfully"));
    }

    @GetMapping("/public/search")
    @Timed("blog.controller.searchPublishedBlogs")
    public ResponseEntity<ApiResponse<List<Blog>>> searchPublishedBlogs(
            @RequestParam @NotBlank(message = "Search keyword cannot be blank") String keyword) {
        
        if (keyword.trim().length() < 2) {
            throw new ValidationException("Search keyword must be at least 2 characters long");
        }
        
        List<Blog> blogs = blogService.searchPublishedBlogs(keyword);
        
        log.info("Search for '{}' returned {} results", keyword, blogs.size());
        
        return ResponseEntity.ok(ApiResponse.success(blogs, 
                String.format("Found %d blogs matching '%s'", blogs.size(), keyword)));
    }

    @GetMapping("/public/author/{author}")
    @Timed("blog.controller.getPublishedBlogsByAuthor")
    public ResponseEntity<ApiResponse<List<Blog>>> getPublishedBlogsByAuthor(
            @PathVariable @NotBlank(message = "Author name cannot be blank") String author) {
        
        List<Blog> blogs = blogService.getPublishedBlogsByAuthor(author);
        
        log.info("Retrieved {} blogs by author: {}", blogs.size(), author);
        
        return ResponseEntity.ok(ApiResponse.success(blogs, 
                String.format("Retrieved %d blogs by %s", blogs.size(), author)));
    }

    // Admin endpoints (for website admin)

    @GetMapping("/admin")
    @Timed("blog.controller.getAllBlogs")
    public ResponseEntity<ApiResponse<List<Blog>>> getAllBlogs() {
        
        List<Blog> blogs = blogService.getAllBlogs();
        
        log.info("Admin retrieved {} blogs", blogs.size());
        
        return ResponseEntity.ok(ApiResponse.success(blogs, 
                String.format("Retrieved %d blogs", blogs.size())));
    }

    @GetMapping("/admin/{id}")
    @Timed("blog.controller.getBlogById")
    public ResponseEntity<ApiResponse<Blog>> getBlogById(
            @PathVariable @NotNull(message = "Blog ID cannot be null") Long id) {
        
        if (id <= 0) {
            throw new ValidationException("Blog ID must be a positive number");
        }
        
        Blog blog = blogService.getBlogById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found with id: " + id));
        
        log.info("Admin retrieved blog with id: {}", id);
        return ResponseEntity.ok(ApiResponse.success(blog, "Blog retrieved successfully"));
    }

    @PostMapping("/admin")
    @Timed("blog.controller.createBlog")
    public ResponseEntity<ApiResponse<Blog>> createBlog(@Valid @RequestBody BlogDto blogDto) {
        Blog createdBlog = blogService.createBlog(blogDto);
        
        log.info("Admin created new blog with id: {} and title: {}", createdBlog.getId(), createdBlog.getTitle());
        
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(createdBlog, "Blog created successfully"));
    }

    @PutMapping("/admin/{id}")
    @Timed("blog.controller.updateBlog")
    public ResponseEntity<ApiResponse<Blog>> updateBlog(
            @PathVariable @NotNull(message = "Blog ID cannot be null") Long id,
            @Valid @RequestBody BlogDto blogDto) {
        
        if (id <= 0) {
            throw new ValidationException("Blog ID must be a positive number");
        }
        
        Blog updatedBlog = blogService.updateBlog(id, blogDto);
        
        log.info("Admin updated blog with id: {}", id);
        
        return ResponseEntity.ok(ApiResponse.success(updatedBlog, "Blog updated successfully"));
    }

    @DeleteMapping("/admin/{id}")
    @Timed("blog.controller.deleteBlog")
    public ResponseEntity<ApiResponse<Void>> deleteBlog(
            @PathVariable @NotNull(message = "Blog ID cannot be null") Long id) {
        
        if (id <= 0) {
            throw new ValidationException("Blog ID must be a positive number");
        }
        
        blogService.deleteBlog(id);
        
        log.info("Admin deleted blog with id: {}", id);
        
        return ResponseEntity.ok(ApiResponse.success(null, "Blog deleted successfully"));
    }

    @GetMapping("/admin/search")
    @Timed("blog.controller.searchAllBlogs")
    public ResponseEntity<ApiResponse<List<Blog>>> searchAllBlogs(
            @RequestParam @NotBlank(message = "Search keyword cannot be blank") String keyword) {
        
        if (keyword.trim().length() < 2) {
            throw new ValidationException("Search keyword must be at least 2 characters long");
        }
        
        List<Blog> blogs = blogService.searchAllBlogs(keyword);
        
        log.info("Admin search for '{}' returned {} results", keyword, blogs.size());
        
        return ResponseEntity.ok(ApiResponse.success(blogs, 
                String.format("Found %d blogs matching '%s'", blogs.size(), keyword)));
    }

    // Utility endpoints for admin

    @GetMapping("/admin/generate-slug")
    @Timed("blog.controller.generateSlug")
    public ResponseEntity<ApiResponse<String>> generateSlug(
            @RequestParam @NotBlank(message = "Title cannot be blank") String title) {
        
        if (title.trim().length() < 3) {
            throw new ValidationException("Title must be at least 3 characters long");
        }
        
        String slug = blogService.generateSlug(title);
        
        log.info("Generated slug '{}' for title '{}'", slug, title);
        
        return ResponseEntity.ok(ApiResponse.success(slug, "Slug generated successfully"));
    }

    @GetMapping("/admin/check-slug")
    @Timed("blog.controller.checkSlugAvailability")
    public ResponseEntity<ApiResponse<Boolean>> checkSlugAvailability(
            @RequestParam @NotBlank(message = "Slug cannot be blank") String slug,
            @RequestParam(required = false) Long excludeId) {
        
        boolean available = excludeId != null ? 
                blogService.isSlugAvailable(slug, excludeId) : 
                blogService.isSlugAvailable(slug);
        
        log.info("Slug '{}' availability check: {}", slug, available ? "available" : "taken");
        
        return ResponseEntity.ok(ApiResponse.success(available, 
                String.format("Slug '%s' is %s", slug, available ? "available" : "already taken")));
    }
}