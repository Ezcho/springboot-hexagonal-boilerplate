package com.seoultech.user.domain.port.out;

import com.seoultech.user.domain.model.Member;
import java.util.List;

public interface MemberRepository {
    List<Member> findAll();
    Member save(Member member);
    Member findByEmail(String email);
    void deleteByEmail(String email);
}
