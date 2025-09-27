package com.ayurveda.shodhanayurveda.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogDto {

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
}