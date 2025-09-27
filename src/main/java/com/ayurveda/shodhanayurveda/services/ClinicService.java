package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import com.ayurveda.shodhanayurveda.dto.ClinicResponseDto;
import com.ayurveda.shodhanayurveda.entity.Clinic;

public interface ClinicService {
    List<Clinic> getAllClinics();
    Clinic getClinicById(Long id);
    List<Clinic> getClinicsByCity(String city);
    
    // New DTO methods for multiple images
    List<ClinicResponseDto> getAllClinicsWithImages();
    ClinicResponseDto getClinicWithImagesById(Long id);
    List<ClinicResponseDto> getClinicsWithImagesByCity(String city);
}
