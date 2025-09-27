package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.repository.ServiceRepo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepo serviceRepo;

    public ServiceServiceImpl(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    @Override
    public List<com.ayurveda.shodhanayurveda.entity.Service> getAllServices() {
        log.info("Fetching all services");
        return serviceRepo.findAll();
    }

    @Override
    public com.ayurveda.shodhanayurveda.entity.Service getServiceById(Long id) {
        log.info("Fetching service with id: {}", id);
        return serviceRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Service not found with id: " + id));
    }

    @Override
    public List<com.ayurveda.shodhanayurveda.entity.Service> getServicesByCategory(String category) {
        log.info("Fetching services by category: {}", category);
        return serviceRepo.findByCategoryIgnoreCase(category);
    }

    @Override
    public com.ayurveda.shodhanayurveda.entity.Service createService(com.ayurveda.shodhanayurveda.entity.Service service) {
        log.info("Creating new service: {}", service.getName());
        return serviceRepo.save(service);
    }

    @Override
    public com.ayurveda.shodhanayurveda.entity.Service updateService(Long id, com.ayurveda.shodhanayurveda.entity.Service service) {
        log.info("Updating service with id: {}", id);
        com.ayurveda.shodhanayurveda.entity.Service existingService = getServiceById(id);
        
        existingService.setName(service.getName());
        existingService.setCategory(service.getCategory());
        existingService.setDescription(service.getDescription());
        existingService.setFaq(service.getFaq());
        existingService.setImageUrl(service.getImageUrl());
        
        return serviceRepo.save(existingService);
    }

    @Override
    public void deleteService(Long id) {
        log.info("Deleting service with id: {}", id);
        com.ayurveda.shodhanayurveda.entity.Service service = getServiceById(id);
        serviceRepo.delete(service);
    }
}