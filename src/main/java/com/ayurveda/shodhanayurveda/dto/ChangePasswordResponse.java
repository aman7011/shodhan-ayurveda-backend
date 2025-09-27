package com.ayurveda.shodhanayurveda.dto;

import lombok.Data;

@Data
public class ChangePasswordResponse {
    private boolean success;
    private String message;
    
    public static ChangePasswordResponse success(String message) {
        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setSuccess(true);
        response.setMessage(message);
        return response;
    }
    
    public static ChangePasswordResponse error(String message) {
        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }
}