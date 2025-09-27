package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import com.ayurveda.shodhanayurveda.entity.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategoriesWithDiseases();
    Category getCategoryWithDiseases(Long id);
}