package com.moovda_project.moovda.comment.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
public class CommentPostDto {
    private String content;

    private float star;
}
