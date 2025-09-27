-- Update admin user with correct BCrypt hash for 'admin123'
UPDATE admin_users 
SET password = '$2a$10$RM5YQjwzVJ23EyhUrgbA7.dwDW9TA2m7nHic1OAMGQjXVcaEsoJKK'
WHERE username = 'admin';