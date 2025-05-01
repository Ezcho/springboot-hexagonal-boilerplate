package com.seoultech.user.adapter.in.web.dto.response;

import com.seoultech.user.domain.model.Member;
import lombok.Getter;

@Getter
public class MyPageResponseDto {
    private Long id;
    private String email;

    public static MyPageResponseDto from(Member member) {
        MyPageResponseDto dto = new MyPageResponseDto();
        dto.id = member.getId();
        dto.email = member.getEmail();
        return dto;
    }
}
