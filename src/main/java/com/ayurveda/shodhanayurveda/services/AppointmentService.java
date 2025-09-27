package com.ayurveda.shodhanayurveda.services;

import java.util.List;

import com.ayurveda.shodhanayurveda.entity.Appointment;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long id);
    Appointment createAppointment(Appointment appointment);
}