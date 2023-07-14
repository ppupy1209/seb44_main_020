package com.moovda_project.moovda.global.auth.config;

import com.moovda_project.moovda.global.auth.filter.JwtAuthenticationFilter;
import com.moovda_project.moovda.global.auth.filter.JwtVerificationFilter;
import com.moovda_project.moovda.global.auth.handler.MemberAccessDeniedHandler;
import com.moovda_project.moovda.global.auth.handler.MemberAuthenticationEntryPoint;
import com.moovda_project.moovda.global.auth.handler.MemberAuthenticationFailureHandler;
import com.moovda_project.moovda.global.auth.handler.MemberAuthenticationSuccessHandler;
import com.moovda_project.moovda.global.auth.jwt.JwtTokenizer;
import com.moovda_project.moovda.global.utils.CustomAuthorityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.*;

@Configuration
public class SecurityConfiguration {

    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;


    public SecurityConfiguration(JwtTokenizer jwtTokenizer, CustomAuthorityUtils authorityUtils) {
        this.jwtTokenizer = jwtTokenizer;
        this.authorityUtils = authorityUtils;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
                .cors(withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer())
                .and()
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/","/**").permitAll()
                        .anyRequest().permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // (8)
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));   // (8-1)
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PATCH", "DELETE"));  // (8-2)
        configuration.setAllowedHeaders(Arrays.asList("*")); // CORS 정책 추가 (1)
        configuration.setExposedHeaders(Arrays.asList("*")); // CORS 정책 추가 (2)

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();   // (8-3)
        source.registerCorsConfiguration("/**", configuration);      // (8-4)     주의 사항: 콘텐츠 표시 오류로 인해 '/**'를 '\/**'로 표기했으니 실제 코드 구현 시에는 '\(역슬래시)'를 빼 주세요.
        return source;
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {  // (2-2)
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);  // (2-3)

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer);  // (2-4)
            jwtAuthenticationFilter.setFilterProcessesUrl("/v11/auth/login");// (2-5)
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer, authorityUtils);

            builder.addFilter(jwtAuthenticationFilter)  // (2-6)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);

        }
    }
}
