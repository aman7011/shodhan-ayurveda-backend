package com.ayurveda.shodhanayurveda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayurveda.shodhanayurveda.entity.Category;
import com.ayurveda.shodhanayurveda.entity.Disease;

@Repository
public interface DiseaseRepo extends JpaRepository<Disease, Long> {

    List<Disease> findByCategory(Category category);
    
    List<Disease> findByCategoryId(Long categoryId);
    
    @Query("SELECT d FROM Disease d WHERE d.category.name = :categoryName")
    List<Disease> findByCategoryName(@Param("categoryName") String categoryName);
}