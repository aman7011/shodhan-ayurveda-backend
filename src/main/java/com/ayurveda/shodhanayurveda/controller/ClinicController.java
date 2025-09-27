package com.ayurveda.shodhanayurveda.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.ayurveda.shodhanayurveda.dto.ClinicResponseDto;
import com.ayurveda.shodhanayurveda.entity.Clinic;
import com.ayurveda.shodhanayurveda.services.ClinicService;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") // frontend port
public class ClinicController {
    private final ClinicService clinicService;

    @GetMapping
    public List<ClinicResponseDto> getAllClinics(@RequestParam(required = false) String city) {
        if (city != null) {
            return clinicService.getClinicsWithImagesByCity(city);
        }
        return clinicService.getAllClinicsWithImages();
    }

    @GetMapping("/{id}")
    public ClinicResponseDto getClinicById(@PathVariable Long id) {
        return clinicService.getClinicWithImagesById(id);
    }

    // Keep backward compatibility endpoints if needed
    @GetMapping("/basic")
    public List<Clinic> getAllClinicsBasic(@RequestParam(required = false) String city) {
        if (city != null) {
            return clinicService.getClinicsByCity(city);
        }
        return clinicService.getAllClinics();
    }

    @GetMapping("/basic/{id}")
    public Clinic getClinicByIdBasic(@PathVariable Long id) {
        return clinicService.getClinicById(id);
    }
}
