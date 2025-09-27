-- ===========================================
-- V6__create_services_table.sql
-- Table creation for Services
-- ===========================================

CREATE TABLE services (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    description VARCHAR(2000),
    image_Url VARCHAR(1000),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


INSERT INTO services (name, category, description, image_Url) VALUES
('Panchakarma', 'Treatment', 
 'Ayurvedic detoxification therapy involving massages, steam therapy, and herbal treatments.',
 '/images/services/panchakarma.jpg'),

('Clinic Appointment', 'Appointment', 
 'Book an appointment at our clinic with our experienced Ayurvedic doctors.',
 '/images/services/clinic-appointment.jpg'),

('Call Consultation', 'Consultation', 
 'Schedule a telephonic consultation with our Ayurvedic specialists.',
 '/images/services/call-consultation.jpg');
