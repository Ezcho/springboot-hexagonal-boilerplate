package com.seoultech.user.adapter.in.web.controller;

import com.seoultech.user.adapter.in.web.dto.request.CreateMemberRequest;
import com.seoultech.user.adapter.in.web.dto.request.MemberDto;
import com.seoultech.user.adapter.in.web.dto.response.MyPageResponseDto;
import com.seoultech.user.adapter.in.web.dto.response.NormalResponseDto;
import com.seoultech.user.adapter.in.web.resolver.CurrentUserEmail;
import com.seoultech.user.domain.model.Member;
import com.seoultech.user.domain.port.in.MemberUseCase;
import com.seoultech.user.domain.service.command.CreateMemberCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberUseCase service;

    public MemberController(MemberUseCase service) {
        this.service = service;
    }

    @GetMapping
    public List<Member> getMembers() {
        return service.getAllMembers();
    }

    @GetMapping("/me")
    public ResponseEntity<MyPageResponseDto> getUserInfo(@CurrentUserEmail String email) {
        Member member =  service.getByEmail(email);
        return ResponseEntity.ok(MyPageResponseDto.from(member));
    }

    @DeleteMapping
    public ResponseEntity<NormalResponseDto> deleteUser(@CurrentUserEmail String email){
        service.deleteByEmail(email);
        return ResponseEntity.ok().body(NormalResponseDto.from("성공적으로 삭제되었습니다."));
    }
    @PutMapping
    public ResponseEntity<NormalResponseDto> modifyUser(@CurrentUserEmail String email, @RequestBody MemberDto memberDto){
        //TODO: 유저 정보 수정을 위한 개발 필요
        return null;
    }
}
