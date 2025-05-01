package com.seoultech.user.adapter.in.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor(staticName = "from")
public class NormalResponseDto {
    private final String message;
}
