package com.ayurveda.shodhanayurveda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "clinics")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String phone;
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String imageUrls; // Store as JSON array string
    
    // Helper method to get images as List
    public List<String> getImageUrlList() {
        if (imageUrls == null || imageUrls.trim().isEmpty()) {
            return new ArrayList<>();
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(imageUrls, new TypeReference<List<String>>() {});
        } catch (JsonProcessingException e) {
            return new ArrayList<>();
        }
    }
    
    // Helper method to set images from List
    public void setImageUrlList(List<String> imageUrlList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.imageUrls = mapper.writeValueAsString(imageUrlList != null ? imageUrlList : new ArrayList<>());
        } catch (JsonProcessingException e) {
            this.imageUrls = "[]";
        }
    }
}