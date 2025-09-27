package com.ayurveda.shodhanayurveda.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogResponseDto {

    private Long id;
    private String title;
    private String slug;
    private String content;
    private String summary;
    private String author;
    private String imageUrl;
    private String tags;
    private Boolean published;
    private Boolean featured;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime publishedAt;

    // Method to convert entity to DTO
    public static BlogResponseDto fromEntity(com.ayurveda.shodhanayurveda.entity.Blog blog) {
        return BlogResponseDto.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .slug(blog.getSlug())
                .content(blog.getContent())
                .summary(blog.getSummary())
                .author(blog.getAuthor())
                .imageUrl(blog.getImageUrl())
                .tags(blog.getTags())
                .published(blog.getPublished())
                .featured(blog.getFeatured())
                .createdAt(blog.getCreatedAt())
                .updatedAt(blog.getUpdatedAt())
                .publishedAt(blog.getPublishedAt())
                .build();
    }
}