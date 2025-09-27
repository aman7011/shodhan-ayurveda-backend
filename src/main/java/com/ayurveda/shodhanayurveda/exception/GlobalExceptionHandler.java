package com.ayurveda.shodhanayurveda.exception;

import com.ayurveda.shodhanayurveda.dto.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(
            ResourceNotFoundException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.warn("Resource not found - CorrelationId: {}, Path: {}, Message: {}", 
                correlationId, request.getRequestURI(), ex.getMessage());
        
        ApiResponse<Void> response = ApiResponse.error("RESOURCE_NOT_FOUND", ex.getMessage(), correlationId);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(
            ValidationException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.warn("Validation error - CorrelationId: {}, Path: {}, Message: {}", 
                correlationId, request.getRequestURI(), ex.getMessage());
        
        ApiResponse<Void> response = ApiResponse.error("VALIDATION_ERROR", ex.getMessage(), correlationId);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(
            BadRequestException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.warn("Bad request - CorrelationId: {}, Path: {}, Message: {}", 
                correlationId, request.getRequestURI(), ex.getMessage());
        
        ApiResponse<Void> response = ApiResponse.error("BAD_REQUEST", ex.getMessage(), correlationId);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ApiResponse<Void>> handleServiceException(
            ServiceException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.error("Service error - CorrelationId: {}, Path: {}, Message: {}", 
                correlationId, request.getRequestURI(), ex.getMessage(), ex);
        
        ApiResponse<Void> response = ApiResponse.error("SERVICE_ERROR", 
                "An error occurred while processing your request", correlationId);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationErrors(
            MethodArgumentNotValidException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        log.warn("Validation errors - CorrelationId: {}, Path: {}, Errors: {}", 
                correlationId, request.getRequestURI(), errors);

        ApiResponse<Void> response = ApiResponse.error("VALIDATION_FAILED", 
                "Validation failed for request", errors);
        response.setCorrelationId(correlationId);
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidJson(
            HttpMessageNotReadableException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.warn("Invalid JSON - CorrelationId: {}, Path: {}, Message: {}", 
                correlationId, request.getRequestURI(), ex.getMessage());
        
        ApiResponse<Void> response = ApiResponse.error("INVALID_JSON", 
                "Invalid JSON format in request body", correlationId);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<Void>> handleDataIntegrityViolation(
            DataIntegrityViolationException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.error("Data integrity violation - CorrelationId: {}, Path: {}", 
                correlationId, request.getRequestURI(), ex);
        
        ApiResponse<Void> response = ApiResponse.error("DATA_INTEGRITY_ERROR", 
                "Data integrity constraint violation", correlationId);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleIllegalArgument(
            IllegalArgumentException ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.warn("Illegal argument - CorrelationId: {}, Path: {}, Message: {}", 
                correlationId, request.getRequestURI(), ex.getMessage());
        
        ApiResponse<Void> response = ApiResponse.error("INVALID_ARGUMENT", ex.getMessage(), correlationId);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(
            Exception ex, HttpServletRequest request) {
        String correlationId = generateCorrelationId();
        log.error("Unexpected error - CorrelationId: {}, Path: {}, Type: {}, Message: {}", 
                correlationId, request.getRequestURI(), ex.getClass().getSimpleName(), ex.getMessage(), ex);
        
        ApiResponse<Void> response = ApiResponse.error("INTERNAL_ERROR", 
                "An unexpected error occurred. Please try again later.", correlationId);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
