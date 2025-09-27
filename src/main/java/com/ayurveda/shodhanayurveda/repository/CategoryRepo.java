package com.ayurveda.shodhanayurveda.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayurveda.shodhanayurveda.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    
    Optional<Category> findByNameIgnoreCase(String name);
    
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.diseases WHERE c.id = :id")
    Optional<Category> findByIdWithDiseases(@Param("id") Long id);
    
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.diseases")
    List<Category> findAllWithDiseases();
}