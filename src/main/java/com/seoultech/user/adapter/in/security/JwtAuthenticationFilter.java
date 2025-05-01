    package com.seoultech.user.adapter.in.security;

    import com.seoultech.user.adapter.out.exception.InvalidTokenException;
    import com.seoultech.user.adapter.out.security.JwtProvider;
    import com.seoultech.user.domain.port.out.JwtPort;
    import jakarta.servlet.FilterChain;
    import jakarta.servlet.ServletException;
    import jakarta.servlet.http.HttpServletRequest;
    import jakarta.servlet.http.HttpServletResponse;
    import org.springframework.http.HttpStatus;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
    import org.springframework.web.filter.OncePerRequestFilter;

    import java.io.IOException;
    import java.util.List;

    public class JwtAuthenticationFilter extends OncePerRequestFilter {

        private final JwtPort jwtPort;

        public JwtAuthenticationFilter(JwtPort jwtPort) {
            this.jwtPort = jwtPort;
        }

        @Override
        protected void doFilterInternal(HttpServletRequest request,
                                        HttpServletResponse response,
                                        FilterChain filterChain) throws ServletException, IOException {
            try {
                String token = resolveToken(request);
                if (token != null) {
                    jwtPort.validateAccessToken(token);
                    String email = jwtPort.getEmailFromAccessToken(token);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(email, null, List.of());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }

                filterChain.doFilter(request, response);

            } catch (InvalidTokenException e) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json");
                response.getWriter().write(
                        String.format("{\"code\":\"INVALID_TOKEN\",\"message\":\"%s\"}", e.getMessage())
                );
            }
        }


        private String resolveToken(HttpServletRequest request) {
            String bearerToken = request.getHeader("Authorization");
            if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
                return bearerToken.substring(7); // "Bearer " 이후 토큰만 추출
            }
            return null;
        }
    }
