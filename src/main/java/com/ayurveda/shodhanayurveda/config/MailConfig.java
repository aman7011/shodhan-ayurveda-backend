package com.ayurveda.shodhanayurveda.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

@Configuration
@Slf4j
public class MailConfig {

    @Value("${spring.mail.host:smtp.gmail.com}")
    private String host;

    @Value("${spring.mail.port:587}")
    private int port;

    @Value("${spring.mail.username:}")
    private String username;

    @Value("${spring.mail.password:}")
    private String password;

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        
        log.info("Initializing Mail Configuration - Host: {}, Port: {}", host, port);
        
        mailSender.setHost(host);
        mailSender.setPort(port);
        
        // Only set credentials if they are provided
        if (username != null && !username.isEmpty()) {
            mailSender.setUsername(username);
            log.info("Mail username configured: {}", username);
        } else {
            log.error("Mail username not configured. Check your .env file or environment variables.");
        }
        
        if (password != null && !password.isEmpty()) {
            mailSender.setPassword(password);
            log.info("Mail password configured (length: {} characters)", password.length());
        } else {
            log.error("Mail password not configured. Check your .env file or environment variables.");
        }

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "false"); // Set to true for debugging
        props.put("mail.smtp.connectiontimeout", "10000"); // 10 seconds
        props.put("mail.smtp.timeout", "10000"); // 10 seconds
        props.put("mail.smtp.writetimeout", "10000"); // 10 seconds
        
        // Gmail specific settings
        if (host.contains("gmail")) {
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        }

        log.info("Mail configuration completed successfully");
        
        return mailSender;
    }
}