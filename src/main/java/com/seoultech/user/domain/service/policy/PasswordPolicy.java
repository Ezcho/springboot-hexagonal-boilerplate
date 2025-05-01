package com.seoultech.user.domain.service.policy;

import java.util.regex.Pattern;

public class PasswordPolicy {

    private static final int MIN = 8;
    private static final int MAX = 16;

    private static final Pattern UPPER_CASE = Pattern.compile("[A-Z]");
    private static final Pattern LOWER_CASE = Pattern.compile("[a-z]");
    private static final Pattern DIGIT = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHAR = Pattern.compile("[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\\\\\-]");
    private static final Pattern WHITESPACE = Pattern.compile("\\s");

    public static void validate(String password) {
        if (password == null || password.length() < MIN || password.length() > MAX) {
            throw new IllegalArgumentException("비밀번호는 " + MIN + "자 이상 " + MAX + "자 이하여야 합니다.");
        }
        if (!UPPER_CASE.matcher(password).find()) {
            throw new IllegalArgumentException("비밀번호에 최소 하나의 대문자가 포함되어야 합니다.");
        }
        if (!LOWER_CASE.matcher(password).find()) {
            throw new IllegalArgumentException("비밀번호에 최소 하나의 소문자가 포함되어야 합니다.");
        }
        if (!DIGIT.matcher(password).find()) {
            throw new IllegalArgumentException("비밀번호에 최소 하나의 숫자가 포함되어야 합니다.");
        }
        if (!SPECIAL_CHAR.matcher(password).find()) {
            throw new IllegalArgumentException("비밀번호에 최소 하나의 특수문자가 포함되어야 합니다.");
        }
        if (WHITESPACE.matcher(password).find()) {
            throw new IllegalArgumentException("비밀번호에 공백이 포함되어서는 안 됩니다.");
        }

        // TODO: 연속 문자 검사, 사용자 이메일/ID 포함 여부 검사는 필요시 도입
    }
}
