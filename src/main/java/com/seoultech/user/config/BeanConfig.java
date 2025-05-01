package com.seoultech.user.config;

import com.seoultech.user.domain.model.Member;
import com.seoultech.user.domain.port.in.AuthUseCase;
import com.seoultech.user.domain.port.in.MemberUseCase;
import com.seoultech.user.domain.port.out.JwtPort;
import com.seoultech.user.domain.port.out.MemberRepository;
import com.seoultech.user.domain.service.AuthService;
import com.seoultech.user.domain.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public MemberUseCase getMembersQuery(MemberRepository repository) {
        return new MemberService(repository);
    }
    @Bean
    public AuthUseCase processAuth(MemberRepository repository, JwtPort jwtPort){return new AuthService(repository, jwtPort);}

}
