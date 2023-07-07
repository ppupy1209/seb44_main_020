package com.moovda_project.moovda.member.service;

import com.moovda_project.moovda.member.entity.Member;
import com.moovda_project.moovda.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

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
}
