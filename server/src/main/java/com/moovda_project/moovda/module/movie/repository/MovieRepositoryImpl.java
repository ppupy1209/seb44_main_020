package com.moovda_project.moovda.module.movie.repository;

import com.moovda_project.moovda.module.genre.entity.QGenre;
import com.moovda_project.moovda.module.movie.dto.MovieSearchDto;
import com.moovda_project.moovda.module.movie.dto.QMovieSearchDto;
import com.moovda_project.moovda.module.movie.entity.QMovie;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.moovda_project.moovda.module.genre.entity.QGenre.*;
import static com.moovda_project.moovda.module.genre.entity.QMovieGenre.*;
import static com.moovda_project.moovda.module.movie.entity.QMovie.*;
import static org.thymeleaf.util.StringUtils.*;

public class MovieRepositoryImpl implements MovieRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public MovieRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<MovieSearchDto> search(MovieSearchCondition condition, Pageable pageable) {
        QueryResults<MovieSearchDto> results = queryFactory
                .selectDistinct(new QMovieSearchDto(
                        movie.movieId,
                        movie.title,
                        movie.poster,
                        movie.openingDate,
                        movie.starAvg
                ))
                .from(movie)
                .leftJoin(movie.movieGenres, movieGenre)
                .leftJoin(movieGenre.genre, genre)
                .where(
                        genreNameEq(condition.getGenre()),
                        countryEq(condition.getCountry()),
                        ratingEq(condition.getRating()),
                        starAvgBetween(condition.getStartStarAvg(), condition.getEndStarAvg()),
                        searchKeyWordLike(condition.getKeyword())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<MovieSearchDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content,pageable,total);
    }

    private BooleanExpression genreNameEq(String genre) {
        return isEmpty(genre) ? null : QGenre.genre.name.eq(genre);
    }

    private BooleanExpression countryEq(String country) {
        return StringUtils.isEmpty(country) ? null : QMovie.movie.country.eq(country);
    }

    private BooleanExpression ratingEq(String rating) {
        return rating == null ? null : QMovie.movie.rating.eq(rating);
    }

    private BooleanExpression starAvgBetween(Double startStarAvg, Double endStarAvg) {
        if (startStarAvg == null && endStarAvg == null) {
            return null;
        } else if (startStarAvg == null) {
            return QMovie.movie.starAvg.loe(endStarAvg);
        } else if (endStarAvg == null) {
            return QMovie.movie.starAvg.goe(startStarAvg);
        } else {
            return QMovie.movie.starAvg.between(startStarAvg, endStarAvg);
        }
    }

    private BooleanExpression searchKeyWordLike(String keyword) {
        if(StringUtils.isEmpty(keyword)) {
            return null;
        } else {
            return movie.title.containsIgnoreCase(keyword)
                    .or(movie.movieStaffs.any().staff.name.containsIgnoreCase(keyword));

        }
    }
}
