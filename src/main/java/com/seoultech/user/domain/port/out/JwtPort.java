package com.seoultech.user.domain.port.out;


import com.seoultech.user.domain.model.TokenBundle;

public interface JwtPort {
    void validateAccessToken(String token);
    void validateRefreshToken(String token);

    String getEmailFromAccessToken(String token);
    String getEmailFromRefreshToken(String token);
    TokenBundle generateTokenBundle(String email);

}

