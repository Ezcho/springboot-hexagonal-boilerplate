package com.seoultech.user.domain.model;

import lombok.Getter;

@Getter
public class Member {
    private final Long id;
    private final String email;
    private final String password;

    //회원가입을 위한 아이디가 없는 생성자
    public Member(String email, String password) {this(null, email, password);}

    //조회 및 삭제에서 사용되는 아이디가 있는 생성자
    public Member(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

}
