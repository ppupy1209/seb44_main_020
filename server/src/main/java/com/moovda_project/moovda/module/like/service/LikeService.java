package com.moovda_project.moovda.module.like.service;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.comment.service.CommentService;
import com.moovda_project.moovda.module.like.entity.Like;
import com.moovda_project.moovda.module.comment.repository.CommentRepository;
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
    private final CommentRepository commentRepository;

    public void addLike(long memberId, long commentId) {

        Comment comment = commentService.findVerifiedComment(commentId);
        Member member = memberService.findVerifiedMember(memberId);
        Like like = new Like(member,comment);

        if(isNotAlreadyLike(member,comment)) {
            comment.addLikes(like);

            commentRepository.save(comment);

            likeRepository.save(like);
        }
        else {
            comment.removeLikes(like);

            commentRepository.save(comment);

            likeRepository.deleteByMemberAndComment(member, comment);
        }
    }
    private boolean isNotAlreadyLike(Member member, Comment comment) {
        return likeRepository.findByMemberAndComment(member,comment).isEmpty();
    }
}
