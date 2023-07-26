package com.moovda_project.moovda.module.comment.dto;

import lombok.Getter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Getter
public class CommentPostDto {

    @Size(min = 10, max = 40, message = "10~40자를 입력하세요.")
    private String content;

    @DecimalMin(value = "0.5", message = "최소 별점은 0.5입니다.")
    @DecimalMax(value = "5.0", message = "최대 별점은 5.0입니다.")
    private double star;
}
