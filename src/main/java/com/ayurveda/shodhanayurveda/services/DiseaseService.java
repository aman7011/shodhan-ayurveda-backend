package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import com.ayurveda.shodhanayurveda.entity.Category;
import com.ayurveda.shodhanayurveda.entity.Disease;

public interface DiseaseService {
    List<Disease> getAllDiseases();
    Disease getDiseaseById(Long id);
    List<Disease> getByCategory(Category category);
    List<Disease> getByCategoryId(Long categoryId);
    List<Disease> getByCategoryName(String categoryName);
}