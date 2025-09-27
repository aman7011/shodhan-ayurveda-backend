package com.ayurveda.shodhanayurveda.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayurveda.shodhanayurveda.dto.ChangePasswordRequest;
import com.ayurveda.shodhanayurveda.dto.ChangePasswordResponse;
import com.ayurveda.shodhanayurveda.services.AdminUserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    
    private final AdminUserService adminUserService;
    
    public AdminController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }
    
    @PostMapping("/change-password")
    public ResponseEntity<ChangePasswordResponse> changePassword(
            @RequestBody ChangePasswordRequest request, 
            Principal principal) {
        
        if (principal == null) {
            return ResponseEntity.badRequest()
                    .body(ChangePasswordResponse.error("Authentication required"));
        }
        
        ChangePasswordResponse response = adminUserService.changePassword(principal.getName(), request);
        
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}