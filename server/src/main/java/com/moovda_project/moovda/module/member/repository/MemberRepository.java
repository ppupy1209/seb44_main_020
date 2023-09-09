package com.moovda_project.moovda.module.member.repository;

import com.moovda_project.moovda.module.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    public Member findByNickname(String nickname);

}
