package com.moovda_project.moovda.module.movie.dto.search;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;


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
