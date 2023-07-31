package com.moovda_project.moovda.module.movie.repository;

import com.moovda_project.moovda.module.movie.dto.MovieSearchDto;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieRepositoryCustom {
    Page<MovieSearchDto> search(MovieSearchCondition searchCondition, Pageable pageable);
}
