package com.moovda_project.moovda.member.repository;

import com.moovda_project.moovda.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
