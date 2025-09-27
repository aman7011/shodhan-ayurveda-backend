package com.ayurveda.shodhanayurveda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayurveda.shodhanayurveda.entity.Service;

@Repository
public interface ServiceRepo extends JpaRepository<Service, Long> {
    List<Service> findByCategoryIgnoreCase(String category);
}
