package com.moovda_project.moovda.module.movie.mapper;

import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.movie.dto.CommentResponseDto;
import com.moovda_project.moovda.module.movie.dto.GenreResponseDto;
import com.moovda_project.moovda.module.movie.dto.MovieResponseDto;
import com.moovda_project.moovda.module.movie.dto.StaffResponseDto;
import com.moovda_project.moovda.module.movie.entity.Movie;
import com.moovda_project.moovda.module.movie.entity.genre.Genre;
import com.moovda_project.moovda.module.movie.entity.genre.MovieGenre;
import com.moovda_project.moovda.module.movie.entity.staff.MovieStaff;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
      default MovieResponseDto movieToMovieResponseDto(Movie movie) {
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
          movieResponseDto.setComments(commentToCommentResponseDto(movie.getComments()));

          movieResponseDto.setOpeningDate(movie.getOpeningDate());

          return movieResponseDto;
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

                commentResponseDto.setContent(comment.getContent());
                commentResponseDto.setStar(comment.getStar());
//                commentResponseDto.setNickname(comment.getMember().getNickname);
                commentResponseDto.setLikeCount(comment.getLikes().size());

                commentResponseDtos.add(commentResponseDto);
            }

            return commentResponseDtos;
      }


}
