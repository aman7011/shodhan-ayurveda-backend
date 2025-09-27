package com.ayurveda.shodhanayurveda.controller;

import org.springframework.web.bind.annotation.*;

import com.ayurveda.shodhanayurveda.entity.Disease;
import com.ayurveda.shodhanayurveda.services.DiseaseService;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RestController
@RequestMapping("/api/diseases")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // frontend port
public class DiseaseController {

    private final DiseaseService diseaseService;

    @GetMapping
    public List<Disease> getAllDiseases() {
        return diseaseService.getAllDiseases();
    }

    @GetMapping("/{id}")
    public Disease getDiseaseById(@PathVariable Long id) {
        return diseaseService.getDiseaseById(id);
    }

    @GetMapping("/category/{categoryName}")
    public List<Disease> getByCategoryName(@PathVariable String categoryName) {
        return diseaseService.getByCategoryName(categoryName);
    }

    @GetMapping("/category/id/{categoryId}")
    public List<Disease> getByCategoryId(@PathVariable Long categoryId) {
        return diseaseService.getByCategoryId(categoryId);
    }
}