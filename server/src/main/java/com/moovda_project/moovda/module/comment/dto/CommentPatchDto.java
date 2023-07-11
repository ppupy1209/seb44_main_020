package com.moovda_project.moovda.module.comment.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentPatchDto {

    private long commentId;

    private String content;
    private double star;
}
