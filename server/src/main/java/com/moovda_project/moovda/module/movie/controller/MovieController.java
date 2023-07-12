package com.moovda_project.moovda.module.movie.controller;

import com.moovda_project.moovda.global.dto.SingleResponseDto;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.mapper.MovieMapper;
import com.moovda_project.moovda.module.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

     private final MovieService movieService;
     private final MovieMapper mapper;
    @GetMapping("{movie_id}")
    public ResponseEntity getMovie(@PathVariable("movie_id") @Positive long movieId) {
        Movie movie = movieService.findMovie(movieId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.movieToMovieResponseDto(movie)), HttpStatus.OK);
    }
}
