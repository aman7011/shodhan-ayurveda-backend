package com.ayurveda.shodhanayurveda.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @GetMapping("/test/hash")
    public String generateHash(@RequestParam String password) {
        return passwordEncoder.encode(password);
    }
    
    @GetMapping("/test/verify")
    public boolean verifyPassword(@RequestParam String password, @RequestParam String hash) {
        return passwordEncoder.matches(password, hash);
    }
}