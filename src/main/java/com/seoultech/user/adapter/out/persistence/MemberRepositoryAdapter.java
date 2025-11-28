package com.seoultech.user.adapter.out.persistence;

import com.seoultech.user.domain.exceptions.MemberNotFoundException;
import com.seoultech.user.domain.model.Member;
import com.seoultech.user.domain.port.out.MemberRepository;
import com.seoultech.user.domain.service.command.LoginCommand;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberRepositoryAdapter implements MemberRepository {
    private final MemberJpaRepository jpaRepository;

    public MemberRepositoryAdapter(MemberJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Member> findAll() {
        return jpaRepository.findAll().stream()
                .map(e -> new Member(e.getId(), e.getEmail(), e.getPassword()))
                .collect(Collectors.toList());
    }
    @Override
    public Member save(Member member){
        MemberJpaEntity entity = new MemberJpaEntity();
        entity.setEmail(member.getEmail());
        entity.setPassword(member.getPassword());
        MemberJpaEntity saved = jpaRepository.save(entity); //Id값 반환을 위해,
        return new Member(saved.getId(),saved.getEmail(), saved.getPassword());
    }

    @Override
    public Member findByEmail(String email) {
        Optional<MemberJpaEntity> entity = jpaRepository.findByEmail(email);
        if (entity.isPresent()){
            MemberJpaEntity memberJpaEntity = entity.get();
            return new Member(
                    memberJpaEntity.getId(),
                    memberJpaEntity.getEmail(),
                    memberJpaEntity.getPassword()
            );
        }else{
            throw new EntityNotFoundException("이메일에 해당하는 유저를 찾을 수 없습니다.");
        }
    }
    @Override
    @Transactional
    public void deleteByEmail(String email){
        int deleted = jpaRepository.deleteByEmail(email);
        if (deleted == 0){
            throw new MemberNotFoundException(email);
        }
    }

}
