package com.ayurveda.shodhanayurveda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ayurveda.shodhanayurveda.entity.AdminUser;

import java.time.LocalDateTime;

@Repository
public interface AdminUserRepo extends JpaRepository<AdminUser, Long> {
    
    // Find user by username
    Optional<AdminUser> findByUsername(String username);
    
    // Find user by email
    Optional<AdminUser> findByEmail(String email);
    
    // Find active user by username
    @Query("SELECT u FROM AdminUser u WHERE u.username = :username AND u.active = true")
    Optional<AdminUser> findActiveByUsername(@Param("username") String username);
    
    // Check if username exists
    boolean existsByUsername(String username);
    
    // Check if email exists
    boolean existsByEmail(String email);
    
    // Update last login time
    @Modifying
    @Query("UPDATE AdminUser u SET u.lastLogin = :lastLogin WHERE u.id = :id")
    void updateLastLogin(@Param("id") Long id, @Param("lastLogin") LocalDateTime lastLogin);
    
    // Update password
    @Modifying
    @Query("UPDATE AdminUser u SET u.password = :password, u.updatedAt = :updatedAt WHERE u.username = :username")
    void updatePassword(@Param("username") String username, @Param("password") String password, @Param("updatedAt") LocalDateTime updatedAt);
}