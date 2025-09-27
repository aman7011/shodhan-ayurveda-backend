package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayurveda.shodhanayurveda.entity.Category;
import com.ayurveda.shodhanayurveda.entity.Disease;
import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.repository.DiseaseRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DiseaseServiceImpl implements DiseaseService {

    private final DiseaseRepo diseaseRepo;

    @Override
    public List<Disease> getAllDiseases() {
        log.info("Fetching all diseases");
        try {
            return diseaseRepo.findAll();
        } catch (Exception e) {
            log.error("Error fetching all diseases: {}", e.getMessage(), e);
            throw new RuntimeException("Error fetching all diseases", e);
        }
    }

    @Override
    public Disease getDiseaseById(Long id) {
        try {
            return diseaseRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Disease not found with id: " + id));
        } catch (ResourceNotFoundException e) {
            log.warn("Disease not found with id: {}", id);
            throw e;
        } catch (Exception e) {
            log.error("Error fetching disease by id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Error fetching disease by id", e);
        }
    }

    @Override
    public List<Disease> getByCategory(Category category) {
        try {
            return diseaseRepo.findByCategory(category);
        } catch (Exception e) {
            log.error("Error fetching diseases by category '{}': {}", category.getName(), e.getMessage(), e);
            throw new RuntimeException("Error fetching diseases by category", e);
        }
    }

    @Override
    public List<Disease> getByCategoryId(Long categoryId) {
        try {
            return diseaseRepo.findByCategoryId(categoryId);
        } catch (Exception e) {
            log.error("Error fetching diseases by category id {}: {}", categoryId, e.getMessage(), e);
            throw new RuntimeException("Error fetching diseases by category id", e);
        }
    }

    @Override
    public List<Disease> getByCategoryName(String categoryName) {
        try {
            return diseaseRepo.findByCategoryName(categoryName);
        } catch (Exception e) {
            log.error("Error fetching diseases by category name '{}': {}", categoryName, e.getMessage(), e);
            throw new RuntimeException("Error fetching diseases by category name", e);
        }
    }
}
