package com.moovda_project.moovda.module.like.repository;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.like.entity.Like;
import com.moovda_project.moovda.module.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface LikeRepository extends JpaRepository<Like, Long> {
     Optional<Like> findByMemberAndComment(Member member, Comment comment);
     void deleteByMemberAndComment(Member member, Comment comment);
     List<Like> findByMember(Member member);
}
