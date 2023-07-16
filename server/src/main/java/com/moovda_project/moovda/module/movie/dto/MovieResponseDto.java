package com.moovda_project.moovda.module.movie.dto;

import com.moovda_project.moovda.module.comment.dto.CommentResponseDto;
import com.moovda_project.moovda.module.movie.dto.genre.GenreResponseDto;
import com.moovda_project.moovda.module.movie.dto.staff.StaffResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
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
