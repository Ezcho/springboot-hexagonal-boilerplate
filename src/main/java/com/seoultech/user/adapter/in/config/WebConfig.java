package com.seoultech.user.adapter.in.config;

import com.seoultech.user.adapter.in.web.resolver.CurrentUserEmailResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CurrentUserEmailResolver());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//모든 경로
                .allowedOrigins("**", "https://my-domain.com") //FE주소 기재
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 메서드, OPTIONS 미 허용
                .allowedHeaders("*") //모든 헤더 허용
                .exposedHeaders("Authorization") //응답에서 노출할 헤더
                .allowCredentials(true) // 쿠키 인증 허용 시 true
                .maxAge(3600); // pre-flight 캐싱 시간 (초)
    }
}
