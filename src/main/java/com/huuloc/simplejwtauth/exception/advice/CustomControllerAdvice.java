package com.huuloc.simplejwtauth.exception.advice;

import com.huuloc.simplejwtauth.exception.BadRequestException;
import com.huuloc.simplejwtauth.exception.ErrorMessage;
import com.huuloc.simplejwtauth.exception.UnauthorizedException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@ResponseBody
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> badRequest(BadRequestException e) {
        logger.error(e.getMessage(), e.getCause());
        ErrorMessage error = ErrorMessage.builder()
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .timestamp(LocalDateTime.now())
                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .description(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<Object> unauthorizedRequest(UnauthorizedException e) {
        logger.error(e.getMessage(), e.getCause());
        ErrorMessage error = ErrorMessage.builder()
                .code(String.valueOf(HttpStatus.UNAUTHORIZED.value()))
                .timestamp(LocalDateTime.now())
                .message(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .description(e.getMessage())
                .build();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> ex(Exception e) {
        logger.error(e.getMessage(), e.getCause());
        ErrorMessage error = ErrorMessage.builder()
                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .description(e.getMessage())
                .build();
        return ResponseEntity.internalServerError().body(error);
    }
}
