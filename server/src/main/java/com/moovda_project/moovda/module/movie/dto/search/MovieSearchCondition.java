package com.moovda_project.moovda.module.movie.dto.search;


import lombok.*;



@Getter
public class MovieSearchCondition {
    private String genre;
    private String country;
    private String rating;
    private Double startStarAvg;
    private Double endStarAvg;
    private String keyword;
}
