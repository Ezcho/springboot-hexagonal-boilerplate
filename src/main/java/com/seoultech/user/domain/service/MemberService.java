package com.seoultech.user.domain.service;

import com.seoultech.user.domain.model.Member;
import com.seoultech.user.domain.port.in.MemberUseCase;
import com.seoultech.user.domain.port.out.MemberRepository;
import com.seoultech.user.domain.service.command.CreateMemberCommand;
import com.seoultech.user.domain.service.policy.PasswordPolicy;

import java.util.List;


public class MemberService implements MemberUseCase {
    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Member> getAllMembers() {
        return repository.findAll();
    }


    @Override
    public Member getByEmail(String email){
        return repository.findByEmail(email);
    }

    @Override
    public void deleteByEmail(String email){
        repository.deleteByEmail(email);
    }
}
