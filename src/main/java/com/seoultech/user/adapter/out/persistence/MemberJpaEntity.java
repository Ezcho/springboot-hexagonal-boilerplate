package com.seoultech.user.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MemberJpaEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
}
