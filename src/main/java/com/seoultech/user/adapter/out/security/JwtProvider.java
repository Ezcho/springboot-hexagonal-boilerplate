package com.seoultech.user.adapter.out.security;

import com.seoultech.user.adapter.out.exception.InvalidTokenException;
import com.seoultech.user.domain.model.TokenBundle;
import com.seoultech.user.domain.port.out.JwtPort;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtProvider implements JwtPort {

    private final SecretKey accessKey;
    private final SecretKey refreshKey;
    private final long accessExpirationTime;
    private final long refreshExpirationTime;

    public JwtProvider(
            @Value("${jwt.access-secret}") String accessSecret,
            @Value("${jwt.refresh-secret}") String refreshSecret,
            @Value("${jwt.access-expiration-ms}") long accessExpirationTime,
            @Value("${jwt.refresh-expiration-ms}") long refreshExpirationTime
    ) {
        this.accessKey = Keys.hmacShaKeyFor(accessSecret.getBytes(StandardCharsets.UTF_8));
        this.refreshKey = Keys.hmacShaKeyFor(refreshSecret.getBytes(StandardCharsets.UTF_8));
        this.accessExpirationTime = accessExpirationTime;
        this.refreshExpirationTime = refreshExpirationTime;
    }


    @Override
    public TokenBundle generateTokenBundle(String email){
        String accessToken = generateAccessToken(email);
        String refreshToken = generateRefreshToken(email);
        return new TokenBundle(accessToken, refreshToken, accessExpirationTime,refreshExpirationTime);
    }


    private String generateAccessToken(String email) {
        return generateToken(email, accessKey, accessExpirationTime);
    }


    private String generateRefreshToken(String email) {
        return generateToken(email, refreshKey, refreshExpirationTime);
    }

    private String generateToken(String subject, SecretKey key, long duration) {
        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + duration))
                .signWith(key)
                .compact();
    }

    @Override
    public String getEmailFromAccessToken(String token) {
        return extractSubject(token, accessKey);
    }

    @Override
    public String getEmailFromRefreshToken(String token) {
        return extractSubject(token, refreshKey);
    }

    private String extractSubject(String token, SecretKey key) {
        try {
            return Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        } catch (ExpiredJwtException e) {
            throw new InvalidTokenException("만료된 토큰입니다.", e);
        } catch (SecurityException | JwtException | IllegalArgumentException e) {
            throw new InvalidTokenException("유효하지 않은 토큰입니다.", e);
        }
    }

    @Override
    public void validateAccessToken(String token) {
        validateToken(token, accessKey);
    }

    @Override
    public void validateRefreshToken(String token) {
        validateToken(token, refreshKey);
    }

    private void validateToken(String token, SecretKey key) {
        extractSubject(token, key);
    }

}
