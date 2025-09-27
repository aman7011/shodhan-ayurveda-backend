-- Fix admin user data with known working BCrypt hash
DELETE FROM admin_users WHERE username = 'admin';

INSERT INTO admin_users (username, password, email, full_name, role, active, created_at, updated_at) VALUES 
(
    'admin',
    '$2a$12$LQv3c1yqBWVHxkd0LHAkCOYz6TtxMQJqfcxg71Cg4K1QiE.qTC42.',
    'admin@shodhanayurveda.com',
    'System Administrator',
    'ADMIN',
    true,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP
);