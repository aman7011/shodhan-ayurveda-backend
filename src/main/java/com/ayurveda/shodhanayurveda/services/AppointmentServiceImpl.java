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
            log.info("Creating appointment for: {} - Service: {}", 
                    appointment.getName(), appointment.getServiceName());
            
            Appointment saved = appointmentRepository.save(appointment);
            log.info("Appointment saved successfully with ID: {}", saved.getId());
            
            // Try to send email, but don't fail the appointment creation if email fails
            try {
                sendAppointmentEmail(saved);
                log.info("Appointment confirmation email sent successfully for appointment ID: {}", saved.getId());
            } catch (Exception e) {
                log.warn("Failed to send appointment email for appointment ID: {}. " +
                        "Appointment was created successfully, but email notification failed. " +
                        "Reason: {}", saved.getId(), e.getMessage());
                // Don't throw exception - appointment creation should succeed even if email fails
            }
            
            return saved;
        } catch (Exception e) {
            log.error("Failed to create appointment: {}. Reason: {}", appointment, e.getMessage(), e);
            throw new RuntimeException("Failed to create appointment", e);
        }
    }

    private void sendAppointmentEmail(Appointment appointment) {
        try {
            log.debug("Attempting to send appointment email for appointment ID: {}", appointment.getId());
            
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("chaturvediaman788@gmail.com"); 
            message.setSubject("New Appointment Request - " + appointment.getServiceName());
            message.setFrom("noreply@shodhanayurveda.com"); // Set a from address

            StringBuilder sb = new StringBuilder();
            sb.append("New Appointment Request Details:\n\n");
            sb.append("Service: ").append(appointment.getServiceName() != null ? appointment.getServiceName() : "Not specified").append("\n");
            sb.append("Patient Name: ").append(appointment.getName()).append("\n");
            sb.append("Phone: ").append(appointment.getPhone()).append("\n");

            if (appointment.getDescription() != null && !appointment.getDescription().isEmpty()) {
                sb.append("Description: ").append(appointment.getDescription()).append("\n");
            }
            if (appointment.getDate() != null) {
                sb.append("Preferred Date: ").append(appointment.getDate()).append("\n");
            }
            
            sb.append("\nAppointment ID: ").append(appointment.getId());
            sb.append("\nCreated At: ").append(appointment.getCreatedAt());
            sb.append("\n\nPlease contact the patient to confirm the appointment.");

            message.setText(sb.toString());

            mailSender.send(message);
            log.debug("Appointment email sent successfully for appointment ID: {}", appointment.getId());
            
        } catch (Exception e) {
            log.error("Error in sendAppointmentEmail for appointment ID: {}. " + 
                     "Error type: {}. Message: {}", 
                     appointment.getId(), e.getClass().getSimpleName(), e.getMessage());
            
            // Check if it's an authentication error and provide specific guidance
            if (e.getMessage() != null && e.getMessage().contains("Authentication failed")) {
                log.error("Email authentication failed. Please check MAIL_USERNAME and MAIL_PASSWORD environment variables are set correctly.");
            }
            
            throw new RuntimeException("Error sending appointment email: " + e.getMessage(), e);
        }
    }
}
