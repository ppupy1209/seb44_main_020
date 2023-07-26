package com.moovda_project.moovda.module.movie.dto;

import com.moovda_project.moovda.global.dto.PageDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PagedMovieFilterResponseDto {
    List<MovieFilterResponseDto> movies;
    PageDto pageInfo;
}
