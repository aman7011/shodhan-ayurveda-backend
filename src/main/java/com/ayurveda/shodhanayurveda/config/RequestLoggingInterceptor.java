package com.ayurveda.shodhanayurveda.config;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
@Slf4j
public class RequestLoggingInterceptor implements HandlerInterceptor {

    private static final String CORRELATION_ID_HEADER = "X-Correlation-ID";
    private static final String CORRELATION_ID_KEY = "correlationId";

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
        String correlationId = request.getHeader(CORRELATION_ID_HEADER);
        
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = UUID.randomUUID().toString().substring(0, 8);
        }
        
        // Add to response header for client tracking
        response.setHeader(CORRELATION_ID_HEADER, correlationId);
        
        // Add to MDC for logging
        MDC.put(CORRELATION_ID_KEY, correlationId);
        
        // Log request
        log.info("Incoming request: {} {} - CorrelationId: {}", 
                request.getMethod(), request.getRequestURI(), correlationId);
        
        // Store start time for performance metrics
        request.setAttribute("startTime", System.currentTimeMillis());
        
        return true;
    }

    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, 
                               @NonNull Object handler, @Nullable Exception ex) {
        try {
            String correlationId = MDC.get(CORRELATION_ID_KEY);
            Long startTime = (Long) request.getAttribute("startTime");
            
            if (startTime != null) {
                long duration = System.currentTimeMillis() - startTime;
                
                if (ex != null) {
                    log.error("Request completed with error: {} {} - Status: {} - Duration: {}ms - CorrelationId: {}", 
                            request.getMethod(), request.getRequestURI(), response.getStatus(), duration, correlationId, ex);
                } else {
                    log.info("Request completed: {} {} - Status: {} - Duration: {}ms - CorrelationId: {}", 
                            request.getMethod(), request.getRequestURI(), response.getStatus(), duration, correlationId);
                }
            }
        } finally {
            // Clean up MDC
            MDC.clear();
        }
    }
}