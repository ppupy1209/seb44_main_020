package com.moovda_project.moovda.module.movie.dto;

import com.moovda_project.moovda.module.movie.entity.genre.Genre;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieSearchDto {
    private Long movieId;
    private String genre;
    private String country;
    private String rating;
    private Double starAvg;

    @QueryProjection
    public MovieSearchDto(Long movieId, String genre, String country, String rating, Double starAvg) {
        this.movieId = movieId;
        this.genre = genre;
        this.country = country;
        this.rating = rating;
        this.starAvg = starAvg;
    }
}
