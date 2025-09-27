-- Remove non-admin users, keeping only admin
DELETE FROM admin_users WHERE username IN ('editor', 'drbiswas');

-- Ensure admin user exists with correct password (BCrypt hash for 'admin123')
UPDATE admin_users 
SET password = '$2a$12$LQv3c1yqBWVHxkd0LHAkCOYz6TtxMQJqfcxg71Cg4K1QiE.qTC42.',
    email = 'admin@shodhanayurveda.com',
    full_name = 'System Administrator',
    role = 'ADMIN',
    active = true
WHERE username = 'admin';