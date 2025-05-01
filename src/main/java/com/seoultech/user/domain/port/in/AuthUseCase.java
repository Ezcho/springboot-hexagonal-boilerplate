package com.seoultech.user.domain.port.in;


import com.seoultech.user.domain.model.Member;
import com.seoultech.user.domain.model.TokenBundle;
import com.seoultech.user.domain.service.command.CreateMemberCommand;
import com.seoultech.user.domain.service.command.LoginCommand;

public interface AuthUseCase {
    TokenBundle signUp(LoginCommand loginCommand);
    Member signIn(CreateMemberCommand createMemberCommand);
}
