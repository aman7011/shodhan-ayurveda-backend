package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayurveda.shodhanayurveda.entity.Category;
import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.repository.CategoryRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> getAllCategories() {
        log.info("Fetching all categories");
        try {
            return categoryRepo.findAll();
        } catch (Exception e) {
            log.error("Error fetching all categories: {}", e.getMessage(), e);
            throw new RuntimeException("Error fetching all categories", e);
        }
    }

    @Override
    public Category getCategoryById(Long id) {
        try {
            return categoryRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        } catch (ResourceNotFoundException e) {
            log.warn("Category not found with id: {}", id);
            throw e;
        } catch (Exception e) {
            log.error("Error fetching category by id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Error fetching category by id", e);
        }
    }

    @Override
    public Category getCategoryByName(String name) {
        try {
            return categoryRepo.findByNameIgnoreCase(name)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with name: " + name));
        } catch (ResourceNotFoundException e) {
            log.warn("Category not found with name: {}", name);
            throw e;
        } catch (Exception e) {
            log.error("Error fetching category by name '{}': {}", name, e.getMessage(), e);
            throw new RuntimeException("Error fetching category by name", e);
        }
    }

    @Override
    public List<Category> getAllCategoriesWithDiseases() {
        log.info("Fetching all categories with their diseases");
        try {
            return categoryRepo.findAllWithDiseases();
        } catch (Exception e) {
            log.error("Error fetching all categories with diseases: {}", e.getMessage(), e);
            throw new RuntimeException("Error fetching all categories with diseases", e);
        }
    }

    @Override
    public Category getCategoryWithDiseases(Long id) {
        try {
            return categoryRepo.findByIdWithDiseases(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        } catch (ResourceNotFoundException e) {
            log.warn("Category not found with id: {}", id);
            throw e;
        } catch (Exception e) {
            log.error("Error fetching category with diseases by id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Error fetching category with diseases by id", e);
        }
    }
}