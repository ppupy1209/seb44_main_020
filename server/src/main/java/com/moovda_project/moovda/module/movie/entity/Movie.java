package com.moovda_project.moovda.module.movie.entity;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.genre.entity.MovieGenre;
import com.moovda_project.moovda.module.staff.entity.MovieStaff;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "movies") // 테이블명 추가
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id",nullable = false,updatable = false)
    private Long movieId;

    @Column(name = "title")
    private String title;

    @Column(name = "country")
    private String country;

    @Column(name = "summary",length = 2000)  // length 255로 부족해서 2000으로 설정
    private String summary;

    @Column(name = "poster",length = 2000) // length 255로 부족해서 2000으로 설정
    private String poster;

    @Column(name = "running_time")
    private Integer runningTime;

    @Column(name = "star_avg")
    private Double starAvg = 0.0;

    @Column(name = "opening_date")
    private String openingDate;

    @Column(name = "rating")
    private String rating;

    @OneToMany(mappedBy = "movie",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<MovieGenre> movieGenres = new ArrayList<>();

    @OneToMany(mappedBy = "movie",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<MovieStaff> movieStaffs = new ArrayList<>();

    @OneToMany(mappedBy = "movie",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();

    public Movie(Long movieId) {
        this.movieId = movieId;
    }

    public void setStarAvg(Double starAvg) {
        this.starAvg = starAvg;
    }

    public void addMovieGenres(MovieGenre movieGenre) {
        this.movieGenres.add(movieGenre);
        if(movieGenre.getMovie()!=this) {
            movieGenre.setMovie(this);
        }
    }

    public void addMovieStaffs(MovieStaff movieStaff) {
        this.movieStaffs.add(movieStaff);
        if(movieStaff.getMovie()!=this) {
            movieStaff.setMovie(this);
        }
    }


    public void removeComments(Comment comment) {
        this.comments.remove(comment);
    }
}
