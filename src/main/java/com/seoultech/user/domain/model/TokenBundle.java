package com.seoultech.user.domain.model;

import lombok.Getter;

@Getter
public class TokenBundle {
    private final String accessToken;
    private final String refreshToken;
    private final long accessTokenExpiresIn;
    private final long refreshTokenExpiresIn;

    public TokenBundle(String accessToken, String refreshToken, long accessTokenExpiresIn, long refreshTokenExpiresIn) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.accessTokenExpiresIn = accessTokenExpiresIn;
        this.refreshTokenExpiresIn = refreshTokenExpiresIn;
    }
}
