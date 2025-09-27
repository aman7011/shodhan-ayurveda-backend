package com.ayurveda.shodhanayurveda.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ayurveda.shodhanayurveda.dto.ClinicResponseDto;
import com.ayurveda.shodhanayurveda.entity.Clinic;
import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.repository.ClinicRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClinicServiceImpl implements ClinicService {

    private final ClinicRepo clinicRepo;

    @Override
    public List<Clinic> getAllClinics() {
        log.info("Fetching all clinics");
        try {
            return clinicRepo.findAll();
        } catch (Exception e) {
            log.error("Error fetching all clinics: {}", e.getMessage(), e);
            throw new RuntimeException("Error fetching all clinics", e);
        }
    }

    @Override
    public Clinic getClinicById(Long id) {
        try {
            return clinicRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Clinic not found with id: " + id));
        } catch (ResourceNotFoundException e) {
            log.warn("Clinic not found with id: {}", id);
            throw e;
        } catch (Exception e) {
            log.error("Error fetching clinic by id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Error fetching clinic by id", e);
        }
    }

    @Override
    public List<Clinic> getClinicsByCity(String city) {
        try {
            return clinicRepo.findByCityIgnoreCase(city);
        } catch (Exception e) {
            log.error("Error fetching clinics by city '{}': {}", city, e.getMessage(), e);
            throw new RuntimeException("Error fetching clinics by city", e);
        }
    }

    // DTO methods for multiple images
    @Override
    public List<ClinicResponseDto> getAllClinicsWithImages() {
        log.info("Fetching all clinics with images");
        try {
            return getAllClinics().stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error fetching all clinics with images: {}", e.getMessage(), e);
            throw new RuntimeException("Error fetching all clinics with images", e);
        }
    }

    @Override
    public ClinicResponseDto getClinicWithImagesById(Long id) {
        log.info("Fetching clinic with images by id: {}", id);
        try {
            Clinic clinic = getClinicById(id);
            return convertToDto(clinic);
        } catch (Exception e) {
            log.error("Error fetching clinic with images by id {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public List<ClinicResponseDto> getClinicsWithImagesByCity(String city) {
        log.info("Fetching clinics with images by city: {}", city);
        try {
            return getClinicsByCity(city).stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            log.error("Error fetching clinics with images by city '{}': {}", city, e.getMessage(), e);
            throw new RuntimeException("Error fetching clinics with images by city", e);
        }
    }

    // Helper method to convert entity to DTO
    private ClinicResponseDto convertToDto(Clinic clinic) {
        return new ClinicResponseDto(
                clinic.getId(),
                clinic.getName(),
                clinic.getAddress(),
                clinic.getCity(),
                clinic.getPhone(),
                clinic.getImageUrlList()
        );
    }
}
