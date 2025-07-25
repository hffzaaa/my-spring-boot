package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityUtil {

	// Private constructor to prevent instantiation
    private ResponseEntityUtil() {
        throw new UnsupportedOperationException("Utility class");
    }

    // --- Utility: standard response creation ---
    public static ResponseEntity<String> buildResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }
}
