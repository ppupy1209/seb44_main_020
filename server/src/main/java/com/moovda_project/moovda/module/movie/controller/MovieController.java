package com.moovda_project.moovda.module.movie.controller;

import com.moovda_project.moovda.global.dto.SingleResponseDto;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.mapper.MovieMapper;
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

    @GetMapping("{movie_id}")
    public ResponseEntity getMovie(@PathVariable("movie_id") @Positive long movieId,
                                   @Positive @RequestParam int page) {
        Movie movie = movieService.findMovie(movieId);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.movieToMovieResponseDto(movie,page,6)), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity searchMovie(MovieSearchCondition condition,
                                      @Positive @RequestParam int page) {
          List<Movie> movies = movieService.filterMovie(condition);

          return new ResponseEntity<>(mapper.moviesToPagedMovieFilterResponseDto(movies,page,10), HttpStatus.OK);

    }


    @GetMapping("/main")
    public ResponseEntity mainMovie() {
        List<Movie> randomMovies = movieService.mainMovie(10);

        return new ResponseEntity<>(mapper.moviesToMovieMainResponseDto(randomMovies),HttpStatus.OK);
    }
}
