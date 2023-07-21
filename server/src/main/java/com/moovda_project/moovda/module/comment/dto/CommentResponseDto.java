package com.moovda_project.moovda.module.comment.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentResponseDto {

    //    String nickname;
    Long memberId;
    Long commentId;
    String content;
    Double star;
    Integer likeCount;

    boolean likeState;
    LocalDateTime createdAt;
}
