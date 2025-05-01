package com.seoultech.user.domain.service;

import com.seoultech.user.domain.model.Member;
import com.seoultech.user.domain.model.TokenBundle;
import com.seoultech.user.domain.port.in.AuthUseCase;
import com.seoultech.user.domain.port.out.JwtPort;
import com.seoultech.user.domain.port.out.MemberRepository;
import com.seoultech.user.domain.service.command.CreateMemberCommand;
import com.seoultech.user.domain.service.command.LoginCommand;
import com.seoultech.user.domain.service.policy.PasswordPolicy;

import java.util.InputMismatchException;

public class AuthService implements AuthUseCase {
    private final MemberRepository repository;
    private final JwtPort jwtPort;
    public AuthService(MemberRepository memberRepository, JwtPort jwtPort){
        this.repository = memberRepository;
        this.jwtPort = jwtPort;
    }
    @Override
    public Member signIn(CreateMemberCommand createMemberCommand){
        PasswordPolicy.validate(createMemberCommand.getPassword());
        return repository.save(new Member(createMemberCommand.getEmail(), createMemberCommand.getPassword()));
    }

    @Override
    public TokenBundle signUp(LoginCommand loginCommand){
        Member member = repository.findByEmail(loginCommand.getEmail());
        if (!member.getPassword().equals(loginCommand.getPassword())){
            throw new InputMismatchException("비밀번호가 일치하지 않습니다.");
        }
        return jwtPort.generateTokenBundle(member.getEmail());
    }
}
