package com.moovda_project.moovda.module.movie.repository;

import com.moovda_project.moovda.module.movie.dto.search.MovieSearchDto;
import com.moovda_project.moovda.module.movie.dto.search.MovieSearchCondition;

import java.util.List;

public interface MovieRepositoryCustom {
    List<MovieSearchDto> search(MovieSearchCondition searchCondition);
}
