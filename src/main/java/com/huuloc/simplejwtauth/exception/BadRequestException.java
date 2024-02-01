package com.huuloc.simplejwtauth.exception;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BadRequestException extends RuntimeException {
    private Integer code;
    private String message;

    public static BadRequestException message(String message) {
        return BadRequestException.builder()
                .message(message)
                .build();
    }
}
