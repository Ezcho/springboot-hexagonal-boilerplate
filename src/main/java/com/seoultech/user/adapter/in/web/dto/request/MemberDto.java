package com.seoultech.user.adapter.in.web.dto.request;

import com.seoultech.user.domain.model.Member;
import lombok.Getter;

@Getter
public class MemberDto {
    private Long id;
    private String email;

    public static MemberDto from(Member member) {
        MemberDto dto = new MemberDto();
        dto.id = member.getId();
        dto.email = member.getEmail();
        return dto;
    }
}
