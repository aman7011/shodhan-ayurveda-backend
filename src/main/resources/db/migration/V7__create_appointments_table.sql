CREATE TABLE appointments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    service_id BIGINT,
    service_name VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    description VARCHAR(2000),
    date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);