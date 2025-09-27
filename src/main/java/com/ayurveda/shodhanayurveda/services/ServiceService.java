package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import com.ayurveda.shodhanayurveda.entity.Service;

public interface ServiceService {
    List<Service> getAllServices();
    Service getServiceById(Long id);
    List<Service> getServicesByCategory(String category);
    Service createService(Service service);
    Service updateService(Long id, Service service);
    void deleteService(Long id);
}