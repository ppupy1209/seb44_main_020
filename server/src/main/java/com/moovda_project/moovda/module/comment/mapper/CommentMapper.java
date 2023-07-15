package com.moovda_project.moovda.module.comment.mapper;

import com.moovda_project.moovda.module.comment.dto.CommentPatchDto;
import com.moovda_project.moovda.module.comment.dto.CommentPostDto;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.like.entity.Like;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;

import java.util.HashSet;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    default Comment commentPostDtoToComment(CommentPostDto commentPostDto,long movieId, long memberId) {
        Comment comment = new Comment();

        comment.setContent(commentPostDto.getContent());
        comment.setStar(commentPostDto.getStar());

        Movie movie = new Movie();
        movie.setMovieId(movieId);

        Member member = new Member();
        member.setMemberId(memberId);

        Set<Like> likes = new HashSet<>();


        comment.setMovie(movie);
        comment.setMember(member);
        comment.setLikes(likes);

        return comment;
    }
    Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto);
}
