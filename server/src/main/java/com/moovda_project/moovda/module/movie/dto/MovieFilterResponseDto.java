package com.moovda_project.moovda.module.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieFilterResponseDto {
    long movieId;
    String title;
    String poster;
    String openingDate;
    Double starAvg;

}
