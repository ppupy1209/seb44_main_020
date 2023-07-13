package com.moovda_project.moovda.global.auth.config;

import com.moovda_project.moovda.global.auth.filter.JwtVerificationFilter;
import com.moovda_project.moovda.global.auth.handler.MemberAccessDeniedHandler;
import com.moovda_project.moovda.global.auth.handler.MemberAuthenticationEntryPoint;
import com.moovda_project.moovda.global.auth.jwt.JwtTokenizer;
import com.moovda_project.moovda.global.auth.userdetails.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfigurationV2 extends WebSecurityConfigurerAdapter {
    private final JwtTokenizer jwtTokenizer;


    public SecurityConfigurationV2(JwtTokenizer jwtTokenizer) {
        this.jwtTokenizer = jwtTokenizer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin() // 동일 출처로부터 들어오는 요청만 허용, H2 사용 위함
                .and()
                .csrf().disable()  // 로컬 환경에서 테스트하기 위함
                .cors(withDefaults()) // CORS 설정 추가, 프론트엔드와 통신
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 세션 생성하지 않음
                .and()
                .formLogin().disable() // SSR 방식이 아닌 CSR 방식
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer()) // 구현한 filter 등록 역할
                .and()
                .authorizeRequests(authorize -> authorize
                        .antMatchers("/","/**").permitAll()
                        .anyRequest().permitAll()
                );

    }

    // 구현한 filter 등록 역할
    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/api/users/sign-in"); // request URL 등록

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer); // Jwt 검증 필터
            builder
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);

        }
    }


    // PasswordEncoder Bean 객체 생성
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // CORS 정책 설정
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // 모든 출처에 대한 통신 허용
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PATCH","DELETE")); // HTTP Method에 대한 통신 허용
        configuration.setAllowedHeaders(Arrays.asList("*")); // CORS 정책 추가 (1)
        configuration.setExposedHeaders(Arrays.asList("*")); // CORS 정책 추가 (2)
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // 모든 URL에 CORS 정책 적용
        return source;
    }

}

