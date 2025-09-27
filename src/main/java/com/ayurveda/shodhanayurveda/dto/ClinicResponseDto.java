package com.ayurveda.shodhanayurveda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicResponseDto {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private List<String> imageUrls;
}