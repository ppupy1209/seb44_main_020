package com.moovda_project.moovda.module.movie.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieMainResponseDto {
    long movieId;
    String poster;
}
