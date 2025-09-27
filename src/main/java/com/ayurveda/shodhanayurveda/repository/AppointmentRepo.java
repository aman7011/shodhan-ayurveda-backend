package com.ayurveda.shodhanayurveda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayurveda.shodhanayurveda.entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Long> {

}
