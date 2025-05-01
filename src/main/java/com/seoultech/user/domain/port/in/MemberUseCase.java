package com.seoultech.user.domain.port.in;

import com.seoultech.user.domain.model.Member;

import java.util.List;

public interface MemberUseCase {
    List<Member> getAllMembers();
    Member getByEmail(String email);
    void deleteByEmail(String email);
}
