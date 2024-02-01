package com.huuloc.simplejwtauth.controller;

import com.huuloc.simplejwtauth.dto.auth.AuthenticationRequest;
import com.huuloc.simplejwtauth.dto.auth.AuthenticationResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(AuthenticationRequest request) {
        return null;
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refresh(HttpServletRequest request,
                                                          HttpServletResponse response) {
        return null;
    }
}
