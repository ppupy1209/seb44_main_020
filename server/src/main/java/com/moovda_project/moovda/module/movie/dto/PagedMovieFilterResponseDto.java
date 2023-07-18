package com.moovda_project.moovda.module.movie.dto;

import com.moovda_project.moovda.global.dto.PageDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PagedMovieFilterResponseDto {
    List<MovieFilterResponseDto> movies;
    PageDto pageInfo;
}
