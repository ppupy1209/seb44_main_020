package com.moovda_project.moovda.module.movie.controller;

import com.moovda_project.moovda.global.dto.SingleResponseDto;
import com.moovda_project.moovda.module.movie.dto.MovieFilterResponseDto;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.mapper.MovieMapper;
import com.moovda_project.moovda.module.movie.repository.MovieRepository;
import com.moovda_project.moovda.module.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

     private final MovieService movieService;
     private final MovieMapper mapper;

     private final MovieRepository movieRepository;

    @GetMapping("{movie_id}")
    public ResponseEntity getMovie(@PathVariable("movie_id") @Positive long movieId) {
        Movie movie = movieService.findMovie(movieId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.movieToMovieResponseDto(movie)), HttpStatus.OK);
    }

    @GetMapping("/search")
    public List<MovieFilterResponseDto> searchMovie(MovieSearchCondition condition) {
          List<Movie> movies = movieService.filterMovie(condition);


          return mapper.moviesToMovieFilterResponseDtos(movies);
    }
}
