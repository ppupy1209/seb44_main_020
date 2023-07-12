package com.moovda_project.moovda.module.movie.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentResponseDto {
//    String nickname;
    String content;
    Double star;
    Integer likeCount;

}
