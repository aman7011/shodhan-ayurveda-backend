package com.ayurveda.shodhanayurveda.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ayurveda.shodhanayurveda.entity.Clinic;

import java.util.List;

public interface ClinicRepo extends JpaRepository<Clinic, Long> {
    List<Clinic> findByCityIgnoreCase(String city);
}
