package com.moovda_project.moovda.module.movie.repository;

import com.moovda_project.moovda.module.movie.dto.MovieSearchDto;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;

import java.util.List;

public interface MovieRepositoryCustom {

    List<MovieSearchDto> search(MovieSearchCondition searchCondition);
}
