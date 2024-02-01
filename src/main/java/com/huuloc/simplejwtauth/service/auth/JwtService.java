package com.huuloc.simplejwtauth.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;

@Service
public class JwtService {
    @Autowired
    private JwtEncoder jwtEncoder;
    @Autowired
    private JwtDecoder jwtDecoder;
    @Value("${jwt.access-token.expiration-time:3600}")
    private int accessTokenExpirationTime;
    @Value("${jwt.refresh-token.expiration-time:86400}")
    private int refreshTokenExpirationTime;

    public String generateAccessToken(UserDetails userDetails) {
        return jwtEncoder.encode(JwtEncoderParameters.
                        from(createClaims(userDetails, accessTokenExpirationTime))
                )
                .getTokenValue();
    }

    public String generateRefreshToken(UserDetails userDetails) {
        return jwtEncoder.encode(JwtEncoderParameters.
                        from(createClaims(userDetails, refreshTokenExpirationTime))
                )
                .getTokenValue();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Instant instant = (Instant) extractClaims(token).get("exp");
        return instant.isBefore(Instant.now());
    }

    public String extractUsername(String token) {
        return extractClaims(token).get("sub").toString();
    }

    private Map<String, Object> extractClaims(String token) {
        return jwtDecoder.decode(token).getClaims();
    }

    private JwtClaimsSet createClaims(UserDetails userDetails, int expirationTime) {
        return JwtClaimsSet.builder()
                .issuer(userDetails.getUsername())
                .subject(userDetails.getUsername())
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(expirationTime))
                .build();
    }
}
