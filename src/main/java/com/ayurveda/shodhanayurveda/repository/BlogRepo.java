package com.ayurveda.shodhanayurveda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayurveda.shodhanayurveda.entity.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {
    
    // Find published blogs ordered by creation date
    @Query("SELECT b FROM Blog b WHERE b.published = true ORDER BY b.createdAt DESC")
    List<Blog> findPublishedBlogsOrderByCreatedAtDesc();
    
    // Find featured blogs
    @Query("SELECT b FROM Blog b WHERE b.published = true AND b.featured = true ORDER BY b.createdAt DESC")
    List<Blog> findFeaturedBlogs();
    
    // Find blog by slug
    Optional<Blog> findBySlug(String slug);
    
    // Find published blog by slug
    @Query("SELECT b FROM Blog b WHERE b.slug = :slug AND b.published = true")
    Optional<Blog> findPublishedBySlug(@Param("slug") String slug);
    
    // Search blogs by title (for admin)
    @Query("SELECT b FROM Blog b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) ORDER BY b.createdAt DESC")
    List<Blog> searchBlogs(@Param("keyword") String keyword);
    
    // Search published blogs by title
    @Query("SELECT b FROM Blog b WHERE b.published = true AND LOWER(b.title) LIKE LOWER(CONCAT('%', :keyword, '%')) ORDER BY b.createdAt DESC")
    List<Blog> searchPublishedBlogs(@Param("keyword") String keyword);
    
    // Find blogs by author
    List<Blog> findByAuthorIgnoreCaseOrderByCreatedAtDesc(String author);
    
    // Find published blogs by author
    @Query("SELECT b FROM Blog b WHERE b.published = true AND LOWER(b.author) = LOWER(:author) ORDER BY b.createdAt DESC")
    List<Blog> findPublishedByAuthor(@Param("author") String author);
    
    // Check if slug exists
    boolean existsBySlug(String slug);
    
    // Check if slug exists excluding current blog (for updates)
    @Query("SELECT COUNT(b) > 0 FROM Blog b WHERE b.slug = :slug AND b.id != :id")
    boolean existsBySlugAndIdNot(@Param("slug") String slug, @Param("id") Long id);
}