package com.moovda_project.moovda.module.movie.service;


import com.moovda_project.moovda.global.exception.BusinessLogicException;
import com.moovda_project.moovda.global.exception.ExceptionCode;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.like.entity.Like;
import com.moovda_project.moovda.module.like.repository.LikeRepository;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.member.service.MemberService;
import com.moovda_project.moovda.module.movie.dto.MovieSearchCondition;
import com.moovda_project.moovda.module.movie.dto.MovieSearchDto;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final MemberService memberService;

    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public Movie findMovie(long movieId,long memberId) {

        Member member = memberService.findVerifiedMember(memberId);

        // 좋아요 정보를 가져오는 쿼리를 사용하여 영화에 해당 멤버의 좋아요 상태를 설정
        List<Like> likes = likeRepository.findByMember(member);

        Movie movie = findVerifiedMovie(movieId);
        List<Comment> comments = movie.getComments();

        // 가져온 좋아요 정보를 바탕으로 각 코멘트의 좋아요 상태를 설정
        for (Comment comment : comments) {
            comment.setLikeState(false); // 기본 값으로 초기화
            for (Like like : likes) {
                if (like.getComment().equals(comment)) {
                    comment.setLikeState(true);
                    break; // 해당 코멘트에 대한 정보를 찾았으면 반복 종료
                }
            }
        }

        return movie;
    }

    public Movie updateMovie(Movie movie) {
        Movie findMovie = findVerifiedMovie(movie.getMovieId());

        Optional.ofNullable(movie.getStarAvg())
                .ifPresent(starAvg -> findMovie.setStarAvg(starAvg));

        return movieRepository.save(findMovie);
    }

    public List<Movie> filterMovie(MovieSearchCondition condition) {
        List<MovieSearchDto> movieSearchDtos = movieRepository.search(condition);

        Set<Long> movieIds = new HashSet<>();
        List<Movie> filteredMovies = new ArrayList<>();

        removeSameMovie(movieSearchDtos, movieIds, filteredMovies); // 중복 영화 제거

        return filteredMovies;
    }

    public List<Movie> mainMovie(int count) {
        List<Movie> allMovies = movieRepository.findAll();
        List<Movie> randomMovies = new ArrayList<>();

        int totalMovies = allMovies.size();

        if(count>=totalMovies) {
            return allMovies;
        }

        Random random = new Random();
        while (randomMovies.size()<count) {
            int randomIndex = random.nextInt(totalMovies);
            Movie randomMovie = allMovies.get(randomIndex);

            if (!randomMovies.contains(randomMovie)) randomMovies.add(randomMovie);
        }

        return randomMovies;
    }

    private void removeSameMovie(List<MovieSearchDto> movieSearchDtos, Set<Long> movieIds, List<Movie> filteredMovies) {
        for (MovieSearchDto movieSearchDto : movieSearchDtos) {
            if (!movieIds.contains(movieSearchDto.getMovieId())) {
                movieIds.add(movieSearchDto.getMovieId());
                Movie movie = findVerifiedMovie(movieSearchDto.getMovieId());
                filteredMovies.add(movie);
            }
        }
    }

    public Movie findVerifiedMovie(long movieId) {
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        Movie movie = optionalMovie.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MOVIE_NOT_FOUND));

        return movie;
    }

}
