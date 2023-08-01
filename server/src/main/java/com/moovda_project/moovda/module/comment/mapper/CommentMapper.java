package com.moovda_project.moovda.module.comment.mapper;

import com.moovda_project.moovda.module.comment.dto.CommentPatchDto;
import com.moovda_project.moovda.module.comment.dto.CommentPostDto;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    default Comment commentPostDtoToComment(CommentPostDto commentPostDto,long movieId, long memberId) {

        Movie movie = new Movie(movieId);
        Member member = new Member(memberId);

        Comment comment = Comment.builder().
                content(commentPostDto.getContent()).
                star(commentPostDto.getStar()).
                movie(movie).
                member(member).
                build();

        return comment;
    }
   Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto) ;
}
