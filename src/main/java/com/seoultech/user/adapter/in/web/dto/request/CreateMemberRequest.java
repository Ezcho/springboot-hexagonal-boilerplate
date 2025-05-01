package com.seoultech.user.adapter.in.web.dto.request;

import lombok.Getter;

@Getter
public class CreateMemberRequest {
    private String email;
    private String password;
}
