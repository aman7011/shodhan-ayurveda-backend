package com.ayurveda.shodhanayurveda.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayurveda.shodhanayurveda.entity.Service;
import com.ayurveda.shodhanayurveda.services.ServiceService;

@RestController
@RequestMapping("/api/services")
@CrossOrigin(origins = "http://localhost:5173") // allow frontend
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping
    public List<Service> getAllServices(@RequestParam(required = false) String category) {
        if (category != null && !category.isEmpty()) {
            return serviceService.getServicesByCategory(category);
        }
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public Service getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id);
    }
}
