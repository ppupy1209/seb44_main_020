package com.moovda_project.moovda.module.movie.controller;

import com.moovda_project.moovda.global.dto.SingleResponseDto;
import com.moovda_project.moovda.global.utils.MemberIdExtractor;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.comment.service.CommentService;
import com.moovda_project.moovda.module.movie.dto.MovieFilterResponseDto;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;
import com.moovda_project.moovda.module.movie.dto.MovieSearchDto;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.mapper.MovieMapper;
import com.moovda_project.moovda.module.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
     private final CommentService commentService;

    @GetMapping("{movie_id}")
    public ResponseEntity getMovie(@PathVariable("movie_id") @Positive long movieId,
                                   @Positive @RequestParam int page) {
        long memberId = MemberIdExtractor.extractMemberId();

        Movie movie = movieService.findMovie(movieId,memberId);

        Pageable pageable = PageRequest.of(page-1,6);

        Page<Comment> commentPage = commentService.findCommentsByMovie(movie,pageable);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.movieToMovieResponseDto(movie,commentPage)), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity searchMovie(MovieSearchCondition condition,
                                      @Positive @RequestParam int page) {
        Pageable pageable = PageRequest.of(page-1,10);
        Page<MovieSearchDto> movieSearchDtos = movieService.filterMovie(condition,pageable);

        return new ResponseEntity<>(new MovieFilterResponseDto<>(movieSearchDtos.getContent(),movieSearchDtos),HttpStatus.OK);
    }


    @GetMapping("/main")
    public ResponseEntity mainMovie() {
        List<Movie> randomMovies = movieService.mainMovie(10);

        return new ResponseEntity<>(mapper.moviesToMovieMainResponseDto(randomMovies),HttpStatus.OK);
    }
}
