package com.moovda_project.moovda.module.movie.mapper;

import com.moovda_project.moovda.global.dto.PageDto;
import com.moovda_project.moovda.module.comment.dto.CommentResponseDto;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.movie.dto.*;
import com.moovda_project.moovda.module.genre.dto.GenreResponseDto;
import com.moovda_project.moovda.module.staff.dto.StaffResponseDto;
import com.moovda_project.moovda.module.movie.entity.Movie;

import com.moovda_project.moovda.module.genre.entity.MovieGenre;
import com.moovda_project.moovda.module.staff.entity.MovieStaff;
import org.mapstruct.Mapper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {
      default MovieResponseDto movieToMovieResponseDto(Movie movie,int page,int pageSize) {

          // 페이지네이션 시작
          List<CommentResponseDto> comments = commentToCommentResponseDto(movie.getComments());
          int totalComments = comments.size();
          int startIndex = (page - 1) * pageSize;
          int endIndex = Math.min(startIndex + pageSize, totalComments);
          List<CommentResponseDto> pagedComments = comments.subList(startIndex, endIndex);
          // 페이지네이션 끝

          PageDto pageDto = PageDto.builder()
                  .currentPage(page)
                  .pageSize(pageSize)
                  .total(totalComments)
                  .build();


          MovieResponseDto movieResponseDto = MovieResponseDto.builder()
                  .movieId(movie.getMovieId())
                  .title(movie.getTitle())
                  .country(movie.getCountry())
                  .summary(movie.getSummary())
                  .poster(movie.getPoster())
                  .runningTime(movie.getRunningTime())
                  .starAvg(movie.getStarAvg())
                  .genre(movieGenresToGenreResponseDto(movie.getMovieGenres()))
                  .staff(movieStaffToStaffResponseDto(movie.getMovieStaffs()))
                  .comments(pagedComments)
                  .pageInfo(pageDto)
                  .openingDate(movie.getOpeningDate())
                  .build();

          return movieResponseDto;
      }

      default PagedMovieFilterResponseDto moviesToPagedMovieFilterResponseDto(List<Movie> movies, int page, int pageSize) {

          // 페이지네이션 시작
          List<MovieFilterResponseDto> movieFilterResponseDtos = moviesToMovieFilterResponseDtos(movies);
          int totalMovies = movieFilterResponseDtos.size();
          int startIndex = (page - 1) * pageSize;
          int endIndex = Math.min(startIndex + pageSize, totalMovies);
          List<MovieFilterResponseDto> pageMovies = movieFilterResponseDtos.subList(startIndex,endIndex);
          // 페이지네이션 끝

          PageDto pageInfo = PageDto.builder()
                  .currentPage(page)
                  .total(totalMovies)
                  .pageSize(pageSize)
                  .build();


          PagedMovieFilterResponseDto pagedMovieFilterResponseDto = PagedMovieFilterResponseDto.builder()
                  .movies(pageMovies)
                  .pageInfo(pageInfo)
                  .build();


          return pagedMovieFilterResponseDto;
      }

      private List<MovieFilterResponseDto> moviesToMovieFilterResponseDtos(List<Movie> movies) {
          List<MovieFilterResponseDto> movieFilterResponseDtos = movies.stream()
                  .map(movie -> MovieFilterResponseDto.builder()
                          .movieId(movie.getMovieId())
                          .title(movie.getTitle())
                          .poster(movie.getPoster())
                          .starAvg(movie.getStarAvg())
                          .build())
                  .collect(Collectors.toList());

          return movieFilterResponseDtos;
      }

      default List<GenreResponseDto> movieGenresToGenreResponseDto(List<MovieGenre> movieGenres) {
          List<GenreResponseDto> genreResponseDtos = movieGenres.stream()
                  .map(movieGenre -> GenreResponseDto.builder()
                          .name(movieGenre.getGenre().getName())
                          .build())
                  .collect(Collectors.toList());

          return genreResponseDtos;
      }

      default List<StaffResponseDto> movieStaffToStaffResponseDto(List<MovieStaff> movieStaffs) {
          List<StaffResponseDto> staffResponseDtos = movieStaffs.stream()
                  .map(movieStaff -> StaffResponseDto.builder()
                          .name(movieStaff.getStaff().getName())
                          .role(movieStaff.getRole())
                          .position(movieStaff.getPosition())
                          .build())
                  .collect(Collectors.toList());

          return staffResponseDtos;
      }

      default List<CommentResponseDto> commentToCommentResponseDto(List<Comment> comments) {

             List<CommentResponseDto> result = comments.stream()
                          .map(comment ->
                              CommentResponseDto.builder().
                                      memberId(comment.getMember().getMemberId()).
                                      commentId(comment.getCommentId()).
                                      nickname(comment.getMember().getNickname()).
                                      content(comment.getContent()).
                                      star(comment.getStar()).
                                      likeCount(comment.getLikes().size()).
                                      likeState(comment.isLikeState()).
                                      createdAt(comment.getCreatedAt()).
                                      build())
                     .collect(Collectors.toList());

          Collections.sort(result, Comparator.comparingInt(CommentResponseDto::getLikeCount).reversed()); // 좋아요 내림차순 정렬

          return result;
      }


      default List<MovieMainResponseDto> moviesToMovieMainResponseDto(List<Movie> movies) {
          List<MovieMainResponseDto> movieMainResponseDtos = movies.stream()
                  .map(movie -> MovieMainResponseDto.builder()
                          .movieId(movie.getMovieId())
                          .poster(movie.getPoster())
                          .build())
                  .collect(Collectors.toList());

          return movieMainResponseDtos;
      }


}
