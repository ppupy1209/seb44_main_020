package com.moovda_project.moovda.global.auth.service;

import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private MemberRepository memberRepository;

    @Autowired
    public CustomOAuth2UserService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String name = (String) attributes.get("name");
        String email = (String) attributes.get("email");

        // 멤버 정보 저장
        Member member = memberRepository.findByName(name);

        if( member == null ) {
            member = Member.builder()
                    .email(email)
                    .nickname(name)
                    .build();
            memberRepository.save(member);
        }

        return oAuth2User;
    }

}
