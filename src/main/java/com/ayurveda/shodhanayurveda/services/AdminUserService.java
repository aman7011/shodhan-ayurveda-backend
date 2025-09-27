package com.ayurveda.shodhanayurveda.services;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayurveda.shodhanayurveda.dto.ChangePasswordRequest;
import com.ayurveda.shodhanayurveda.dto.ChangePasswordResponse;
import com.ayurveda.shodhanayurveda.entity.AdminUser;
import com.ayurveda.shodhanayurveda.repository.AdminUserRepo;

@Service
public class AdminUserService {
    
    private final AdminUserRepo adminUserRepo;
    private final PasswordEncoder passwordEncoder;
    
    public AdminUserService(AdminUserRepo adminUserRepo, PasswordEncoder passwordEncoder) {
        this.adminUserRepo = adminUserRepo;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Transactional
    public ChangePasswordResponse changePassword(String username, ChangePasswordRequest request) {
        try {
            // Find the admin user
            AdminUser adminUser = adminUserRepo.findActiveByUsername(username)
                    .orElse(null);
            
            if (adminUser == null) {
                return ChangePasswordResponse.error("User not found");
            }
            
            // Verify current password
            if (!passwordEncoder.matches(request.getCurrentPassword(), adminUser.getPassword())) {
                return ChangePasswordResponse.error("Current password is incorrect");
            }
            
            // Validate new password
            if (request.getNewPassword() == null || request.getNewPassword().trim().isEmpty()) {
                return ChangePasswordResponse.error("New password cannot be empty");
            }
            
            if (request.getNewPassword().length() < 6) {
                return ChangePasswordResponse.error("New password must be at least 6 characters long");
            }
            
            // Check if new password is same as current
            if (passwordEncoder.matches(request.getNewPassword(), adminUser.getPassword())) {
                return ChangePasswordResponse.error("New password must be different from current password");
            }
            
            // Encrypt new password and update
            String encodedNewPassword = passwordEncoder.encode(request.getNewPassword());
            adminUserRepo.updatePassword(username, encodedNewPassword, LocalDateTime.now());
            
            return ChangePasswordResponse.success("Password updated successfully");
            
        } catch (Exception e) {
            return ChangePasswordResponse.error("Failed to update password: " + e.getMessage());
        }
    }
}