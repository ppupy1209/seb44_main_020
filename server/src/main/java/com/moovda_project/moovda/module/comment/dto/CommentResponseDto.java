package com.moovda_project.moovda.module.comment.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
public class CommentResponseDto {

    //    String nickname;
    Long memberId;
    Long commentId;
    String content;
    Double star;
    Integer likeCount;
    LocalDateTime createdAt;
}
