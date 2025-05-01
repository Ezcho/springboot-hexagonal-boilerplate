package com.seoultech.user.adapter.in.web.dto.response;

import com.seoultech.user.domain.model.TokenBundle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TokenResponseDto {
    private String accessToken;
    private String refreshToken;
    private long accessTokenExpiresIn;
    private long refreshTokenExpiresIn;

    public static TokenResponseDto from(TokenBundle bundle) {
        return new TokenResponseDto(
                bundle.getAccessToken(),
                bundle.getRefreshToken(),
                bundle.getAccessTokenExpiresIn(),
                bundle.getRefreshTokenExpiresIn()
        );
    }
}
