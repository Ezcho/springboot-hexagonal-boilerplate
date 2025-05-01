package com.seoultech.user.adapter.in.web.controller;

import com.seoultech.user.adapter.in.web.dto.request.CreateMemberRequest;
import com.seoultech.user.adapter.in.web.dto.request.LoginRequestDto;
import com.seoultech.user.adapter.in.web.dto.request.MemberDto;
import com.seoultech.user.adapter.in.web.dto.response.TokenResponseDto;
import com.seoultech.user.domain.model.Member;
import com.seoultech.user.domain.model.TokenBundle;
import com.seoultech.user.domain.port.in.AuthUseCase;
import com.seoultech.user.domain.service.command.CreateMemberCommand;
import com.seoultech.user.domain.service.command.LoginCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthUseCase service;
    public AuthController(AuthUseCase authUseCase){
        this.service = authUseCase;
    }
    @PostMapping
    public ResponseEntity<MemberDto> signIn(@RequestBody CreateMemberRequest request) {
        Member member = service.signIn(
                new CreateMemberCommand(request.getEmail(), request.getPassword())
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(MemberDto.from(member));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> signUp(@RequestBody LoginRequestDto loginRequestDto){
        TokenBundle tokenBundle = service.signUp(new LoginCommand(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
        return ResponseEntity.ok(TokenResponseDto.from(tokenBundle));
    }

    //TODO: 비밀번호 재설정 로직
    //TODO: 메일용 controller 개발 필요
}
