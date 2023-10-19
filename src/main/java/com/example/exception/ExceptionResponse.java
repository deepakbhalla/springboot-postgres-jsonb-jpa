package com.example.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime timestamp;
    private String errorMessage;
    private String requestedURI;
}
