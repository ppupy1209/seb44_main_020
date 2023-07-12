package com.moovda_project.moovda.module.search;

import com.moovda_project.moovda.module.movie.entity.genre.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class MovieSearchCondition {
    private String genre;
    private String country;
    private String rating;
    private Double startStarAvg;
    private Double endStarAvg;
}
