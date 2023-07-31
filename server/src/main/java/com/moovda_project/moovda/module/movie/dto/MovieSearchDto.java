package com.moovda_project.moovda.module.movie.dto;


import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MovieSearchDto {
    private Long movieId;
    private String title;
    private String poster;
    private String prodYear;
    private Double starAvg;

    @QueryProjection
    public MovieSearchDto(Long movieId, String title, String poster, String prodYear, Double starAvg) {
        this.movieId = movieId;
        this.title = title;
        this.poster = poster;
        this.prodYear = prodYear;
        this.starAvg = starAvg;
    }
}
