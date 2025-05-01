package com.seoultech.user.domain.exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String email) {
        super("해당 이메일(" + email + ")에 해당하는 유저를 찾을 수 없습니다.");
    }
}

