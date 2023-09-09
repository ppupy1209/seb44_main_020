package com.moovda_project.moovda.module.movie.dto;

import com.moovda_project.moovda.global.dto.PageDto;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MovieFilterResponseDto<T> {
    private List<T> movies;

    private PageDto pageInfo;

    public MovieFilterResponseDto(List<T> movies, Page page) {
        this.movies = movies;
        this.pageInfo = new PageDto(page.getNumber()+1,page.getSize(),page.getTotalElements());
    }

}
