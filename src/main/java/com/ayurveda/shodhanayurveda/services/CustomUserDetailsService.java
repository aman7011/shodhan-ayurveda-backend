package com.ayurveda.shodhanayurveda.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayurveda.shodhanayurveda.entity.AdminUser;
import com.ayurveda.shodhanayurveda.repository.AdminUserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminUserRepo adminUserRepo;

    public CustomUserDetailsService(AdminUserRepo adminUserRepo) {
        this.adminUserRepo = adminUserRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserRepo.findActiveByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Update last login time
        adminUserRepo.updateLastLogin(adminUser.getId(), LocalDateTime.now());

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + adminUser.getRole()));

        return User.builder()
                .username(adminUser.getUsername())
                .password(adminUser.getPassword())
                .authorities(authorities)
                .accountExpired(false)
                .accountLocked(!adminUser.getActive())
                .credentialsExpired(false)
                .disabled(!adminUser.getActive())
                .build();
    }
}