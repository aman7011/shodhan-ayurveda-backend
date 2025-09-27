package com.ayurveda.shodhanayurveda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayurveda.shodhanayurveda.entity.Category;
import com.ayurveda.shodhanayurveda.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // frontend port
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(@RequestParam(required = false, defaultValue = "false") boolean includeDiseases) {
        if (includeDiseases) {
            return categoryService.getAllCategoriesWithDiseases();
        }
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id, 
                                   @RequestParam(required = false, defaultValue = "false") boolean includeDiseases) {
        if (includeDiseases) {
            return categoryService.getCategoryWithDiseases(id);
        }
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }
}