package com.seoultech.user.domain.service.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateMemberCommand {
    private String email;
    private String password;
}
