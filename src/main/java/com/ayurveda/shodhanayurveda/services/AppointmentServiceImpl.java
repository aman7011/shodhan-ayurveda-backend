package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ayurveda.shodhanayurveda.entity.Appointment;
import com.ayurveda.shodhanayurveda.exception.ResourceNotFoundException;
import com.ayurveda.shodhanayurveda.repository.AppointmentRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepo appointmentRepository;
    private final JavaMailSender mailSender;

    @Override
    public List<Appointment> getAllAppointments() {
        log.info("Fetching all appointments");
        try {
            return appointmentRepository.findAll();
        } catch (Exception e) {
            log.error("Error fetching all appointments: {}", e.getMessage(), e);
            throw new RuntimeException("Error fetching all appointments", e);
        }
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        try {
            return appointmentRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id: " + id));
        } catch (ResourceNotFoundException e) {
            log.warn("Appointment not found with id: {}", id);
            throw e;
        } catch (Exception e) {
            log.error("Error fetching appointment by id {}: {}", id, e.getMessage(), e);
            throw new RuntimeException("Error fetching appointment by id", e);
        }
    }

    @Override
    public Appointment createAppointment(Appointment appointment) {
        try {
            Appointment saved = appointmentRepository.save(appointment);
            try {
                sendAppointmentEmail(saved);
            } catch (Exception e) {
                log.error("Failed to send appointment email for appointment: {}. Reason: {}", saved, e.getMessage(), e);
                throw new RuntimeException("Failed to send appointment email", e);
            }
            return saved;
        } catch (Exception e) {
            log.error("Failed to create appointment: {}. Reason: {}", appointment, e.getMessage(), e);
            throw new RuntimeException("Failed to create appointment", e);
        }
    }

    private void sendAppointmentEmail(Appointment appointment) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("chaturvediaman788@gmail.com"); 
            message.setSubject("New Appointment Request - " + appointment.getServiceName());

            StringBuilder sb = new StringBuilder();
            sb.append("Name: ").append(appointment.getName()).append("\n");
            sb.append("Phone: ").append(appointment.getPhone()).append("\n");

            if (appointment.getDescription() != null) {
                sb.append("Description: ").append(appointment.getDescription()).append("\n");
            }
            if (appointment.getDate() != null) {
                sb.append("Date: ").append(appointment.getDate()).append("\n");
            }

            message.setText(sb.toString());

            mailSender.send(message);
        } catch (Exception e) {
            log.error("Error in sendAppointmentEmail for appointment: {}. Reason: {}", appointment, e.getMessage(), e);
            throw new RuntimeException("Error sending appointment email", e);
        }
    }
}
