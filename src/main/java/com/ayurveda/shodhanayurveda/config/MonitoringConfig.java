package com.ayurveda.shodhanayurveda.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Slf4j
public class MonitoringConfig {

    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

    @Bean
    public HealthIndicator databaseHealthIndicator(JdbcTemplate jdbcTemplate) {
        return () -> {
            try {
                jdbcTemplate.queryForObject("SELECT 1", Integer.class);
                return Health.up()
                        .withDetail("database", "Available")
                        .withDetail("query", "SELECT 1")
                        .build();
            } catch (Exception e) {
                log.error("Database health check failed", e);
                return Health.down()
                        .withDetail("database", "Unavailable")
                        .withDetail("error", e.getMessage())
                        .build();
            }
        };
    }

    @Bean
    public HealthIndicator customHealthIndicator() {
        return () -> {
            try {
                // Add your custom health checks here
                // For example: check external APIs, file systems, etc.
                
                return Health.up()
                        .withDetail("application", "Shodhan Ayurveda Backend")
                        .withDetail("version", "1.0.0")
                        .withDetail("status", "All systems operational")
                        .build();
            } catch (Exception e) {
                return Health.down()
                        .withDetail("application", "Shodhan Ayurveda Backend")
                        .withDetail("error", e.getMessage())
                        .build();
            }
        };
    }
}