package com.apekshacare.backend.exception;

import java.time.LocalDateTime;

public record ApiError(
        int status,
        String message,
        LocalDateTime timestamp
) {
}