package com.moovda_project.moovda.module.movie.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CommentResponseDto {
//    String nickname;

    Long memberId;
    Long commentId;
    String content;
    Double star;
    Integer likeCount;


}
