package com.moovda_project.moovda.module.movie.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieFilterResponseDtoV2 {

    List<MovieFilterResponseDto> movies;

    PageDto pageInfo;
}
