package com.moovda_project.moovda.module.like.service;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.comment.service.CommentService;
import com.moovda_project.moovda.module.like.entity.Like;
import com.moovda_project.moovda.module.like.repository.LikeRepository;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final CommentService commentService;
    private final MemberService memberService;

    public void likeOrDislike(long memberId, long commentId) {

        Comment comment = commentService.findVerifiedComment(commentId);
        Member member = memberService.findVerifiedMember(memberId);

        Like like = new Like(member,comment);

        // 좋아요 목록에 있는지 체크
        if(checkExistsLikeByMemberAndComment(member,comment)) {   // 없으면 좋아요 추가
            likeRepository.save(like);

        }
        else {  // 있으면 좋아요 삭제
            likeRepository.deleteByMemberAndComment(member, comment);
        }
    }

    private boolean checkExistsLikeByMemberAndComment(Member member, Comment comment) {
        return likeRepository.findByMemberAndComment(member,comment).isEmpty();
    }
}
