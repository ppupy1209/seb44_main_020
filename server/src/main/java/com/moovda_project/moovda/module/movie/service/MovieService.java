package com.moovda_project.moovda.module.movie.service;


import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;
import com.moovda_project.moovda.module.movie.dto.MovieSearchDto;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Movie findMovie(long movieId) {
        return findverifiedMovie(movieId);
    }

    public Movie updateMovie(Movie movie) {
        Movie findMovie = findverifiedMovie(movie.getMovieId());

        Optional.ofNullable(movie.getStarAvg())
                .ifPresent(starAvg -> findMovie.setStarAvg(starAvg));

        return movieRepository.save(findMovie);
    }

    public List<Movie> filterMovie(MovieSearchCondition condition) {
        List<MovieSearchDto> movieSearchDtos = movieRepository.search(condition);

        Set<Long> movieIds = new HashSet<>();
        List<Movie> filteredMovies = new ArrayList<>();

        for (MovieSearchDto movieSearchDto : movieSearchDtos) {
            if (!movieIds.contains(movieSearchDto.getMovieId())) {
                movieIds.add(movieSearchDto.getMovieId());
                Movie movie = findverifiedMovie(movieSearchDto.getMovieId());
                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }

    private Movie findverifiedMovie(long movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        Movie movie = optionalMovie.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MOVIE_NOT_FOUND));

        return movie;
    }


}
