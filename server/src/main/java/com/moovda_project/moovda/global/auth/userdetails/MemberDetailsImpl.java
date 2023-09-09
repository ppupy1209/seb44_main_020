package com.moovda_project.moovda.global.auth.userdetails;

import com.moovda_project.moovda.module.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberDetailsImpl {

    private Long memberId;
    private String nickname;

    public MemberDetailsImpl(Long memberId, String nickname) {
        this.memberId = memberId;
        this.nickname = nickname;
    }

    public static MemberDetailsImpl build(Member member) {
        return new MemberDetailsImpl(
                member.getMemberId(),
                member.getNickname()
        );
    }
}
