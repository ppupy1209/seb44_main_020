package com.moovda_project.moovda.module.movie.mapper;

import com.moovda_project.moovda.global.dto.PageDto;
import com.moovda_project.moovda.module.comment.dto.CommentResponseDto;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.movie.dto.*;
import com.moovda_project.moovda.module.movie.dto.genre.GenreResponseDto;
import com.moovda_project.moovda.module.movie.dto.staff.StaffResponseDto;
import com.moovda_project.moovda.module.movie.entity.Movie;

import com.moovda_project.moovda.module.movie.entity.genre.MovieGenre;
import com.moovda_project.moovda.module.movie.entity.staff.MovieStaff;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
      default MovieResponseDto movieToMovieResponseDto(Movie movie,int page,int pageSize) {
          MovieResponseDto movieResponseDto = new MovieResponseDto();
          movieResponseDto.setMovieId(movie.getMovieId());
          movieResponseDto.setTitle(movie.getTitle());
          movieResponseDto.setCountry(movie.getCountry());
          movieResponseDto.setSummary(movie.getSummary());
          movieResponseDto.setPoster(movie.getPoster());
          movieResponseDto.setRunningTime(movie.getRunningTime());
          movieResponseDto.setStarAvg(movie.getStarAvg());
          movieResponseDto.setGenre(movieGenresToGenreResponseDto(movie.getMovieGenres()));
          movieResponseDto.setStaff(movieStaffToStaffResponseDto(movie.getMovieStaffs()));

          // 페이지네이션 시작
          List<CommentResponseDto> comments = commentToCommentResponseDto(movie.getComments());
          int totalComments = comments.size();
          int startIndex = (page - 1) * pageSize;
          int endIndex = Math.min(startIndex + pageSize, totalComments);
          List<CommentResponseDto> pagedComments = comments.subList(startIndex, endIndex);

          PageDto pageDto = new PageDto();
          pageDto.setCurrentPage(page);
          pageDto.setPageSize(pageSize);
          pageDto.setTotal(totalComments);
          // 페이지네이션 끝

          movieResponseDto.setComments(pagedComments);
          movieResponseDto.setPageInfo(pageDto);
          movieResponseDto.setOpeningDate(movie.getOpeningDate());

          return movieResponseDto;
      }

      default PagedMovieFilterResponseDto moviesToPagedMovieFilterResponseDto(List<Movie> movies, int page, int pageSize) {
          PagedMovieFilterResponseDto pagedMovieFilterResponseDto = new PagedMovieFilterResponseDto();

          // 페이지네이션 시작
          List<MovieFilterResponseDto> movieFilterResponseDtos = moviesToMovieFilterResponseDtos(movies);
          int totalMovies = movieFilterResponseDtos.size();
          int startIndex = (page - 1) * pageSize;
          int endIndex = Math.min(startIndex + pageSize, totalMovies);
          List<MovieFilterResponseDto> pageMovies = movieFilterResponseDtos.subList(startIndex,endIndex);

          PageDto pageInfo = new PageDto();
          pageInfo.setCurrentPage(page);
          pageInfo.setTotal(totalMovies);
          pageInfo.setPageSize(pageSize);
          // 페이지네이션 끝

          pagedMovieFilterResponseDto.setMovies(pageMovies);
          pagedMovieFilterResponseDto.setPageInfo(pageInfo);

          return pagedMovieFilterResponseDto;
      }

      private List<MovieFilterResponseDto> moviesToMovieFilterResponseDtos(List<Movie> movies) {
          List<MovieFilterResponseDto> movieFilterResponseDtos = new ArrayList<>();

          for(Movie movie : movies) {
                         MovieFilterResponseDto movieFilterResponseDto = new MovieFilterResponseDto();
                         movieFilterResponseDto.setMovieId(movie.getMovieId());
                         movieFilterResponseDto.setTitle(movie.getTitle());
                         movieFilterResponseDto.setPoster(movie.getPoster());
                         movieFilterResponseDto.setStarAvg(movie.getStarAvg());

                         movieFilterResponseDtos.add(movieFilterResponseDto);
                     }
          return movieFilterResponseDtos;
      }

      default List<GenreResponseDto> movieGenresToGenreResponseDto(List<MovieGenre> movieGenres) {
          List<GenreResponseDto> genreResponseDtos = new ArrayList<>();

          for(MovieGenre movieGenre : movieGenres) {
              GenreResponseDto genreResponseDto = new GenreResponseDto();
              genreResponseDto.setName(movieGenre.getGenre().getName());

              genreResponseDtos.add(genreResponseDto);
          }

          return genreResponseDtos;
      }

      default List<StaffResponseDto> movieStaffToStaffResponseDto(List<MovieStaff> movieStaffs) {
          List<StaffResponseDto> staffResponseDtos = new ArrayList<>();

          for (MovieStaff movieStaff : movieStaffs) {
              StaffResponseDto staffResponseDto = new StaffResponseDto();
              staffResponseDto.setName(movieStaff.getStaff().getName());
              staffResponseDto.setRole(movieStaff.getRole());
              staffResponseDto.setPosition(movieStaff.getPosition());

              staffResponseDtos.add(staffResponseDto);
          }

          return staffResponseDtos;
      }

      default List<CommentResponseDto> commentToCommentResponseDto(List<Comment> comments) {
            List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

            for(Comment comment : comments) {
                CommentResponseDto commentResponseDto = new CommentResponseDto();

                commentResponseDto.setMemberId(comment.getMember().getMemberId());
                commentResponseDto.setCommentId(comment.getCommentId());
                commentResponseDto.setContent(comment.getContent());
                commentResponseDto.setStar(comment.getStar());
//                commentResponseDto.setNickname(comment.getMember().getNickname);
                commentResponseDto.setLikeCount(comment.getLikes().size());

                commentResponseDto.setCreatedAt(comment.getCreatedAt());
                commentResponseDtos.add(commentResponseDto);
            }

          Collections.sort(commentResponseDtos, Comparator.comparingInt(CommentResponseDto::getLikeCount).reversed()); // 좋아요 내림차순 정렬

            return commentResponseDtos;
      }


}
