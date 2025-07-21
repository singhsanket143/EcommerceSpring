package org.example.ecommercespring.Exceptions;

import java.security.Timestamp;
import java.time.LocalDateTime;

public class ErrorResponse {
    String message;
    LocalDateTime timestamp;

    ErrorResponse(String message, LocalDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
