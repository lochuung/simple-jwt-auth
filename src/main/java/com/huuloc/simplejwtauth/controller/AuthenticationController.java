package com.huuloc.simplejwtauth.controller;

import com.huuloc.simplejwtauth.dto.auth.AuthenticationRequest;
import com.huuloc.simplejwtauth.dto.auth.AuthenticationResponse;
import com.huuloc.simplejwtauth.service.auth.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService
                .authenticate(request));
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<AuthenticationResponse> refreshToken(HttpServletRequest request,
                                                               HttpServletResponse response) {
        String refreshToken = request.getHeader("Authorization")
                .replace("Bearer ", "");
        return ResponseEntity.ok(authenticationService.refresh(refreshToken));
    }
}
