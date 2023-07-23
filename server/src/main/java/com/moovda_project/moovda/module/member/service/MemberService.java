package com.moovda_project.moovda.module.member.service;

import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {

        Member savedMember = memberRepository.save(member);
        return savedMember;
    }

    public Member findMember(long memberId) {

        return findVerifiedMember(memberId);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }
    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        Member member = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return member;
    }
}
