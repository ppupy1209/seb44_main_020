package com.moovda_project.moovda.movie.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id",nullable = false,updatable = false)
     private Long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "country")
    private String country;

    @Column(name = "summary")
    private String summary;

    @Column(name = "poster")
    private String poster;

    @Column(name = "running_time")
    private Integer runningTime;

    @Column(name = "star_avg")
    private Float starAvg;

    @Column(name = "opening_date")
    private String openingDate;

    @Column(name = "rating")
    private String rating;

}
