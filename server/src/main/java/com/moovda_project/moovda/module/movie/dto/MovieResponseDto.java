package com.moovda_project.moovda.module.movie.dto;

import com.moovda_project.moovda.global.dto.PageDto;
import com.moovda_project.moovda.module.comment.dto.CommentResponseDto;
import com.moovda_project.moovda.module.genre.dto.GenreResponseDto;
import com.moovda_project.moovda.module.staff.dto.StaffResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class MovieResponseDto {
    long movieId;
    String title;
    String country;
    String summary;
    String poster;
    Integer runningTime;
    Double starAvg;

    List<GenreResponseDto> genre;
    List<StaffResponseDto> staff;

    String openingDate;

    List<CommentResponseDto> comments;

    PageDto pageInfo;

}
