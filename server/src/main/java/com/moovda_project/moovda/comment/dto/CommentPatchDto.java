package com.moovda_project.moovda.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentPatchDto {

    private long commentId;

    private String content;
    private float star;
}
