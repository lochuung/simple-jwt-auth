package com.huuloc.simplejwtauth.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private String code;
    private String message;
    private String description;
    private LocalDateTime timestamp;
}
