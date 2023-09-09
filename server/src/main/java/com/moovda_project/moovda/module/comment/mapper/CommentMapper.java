package com.moovda_project.moovda.module.comment.mapper;

import com.moovda_project.moovda.module.comment.dto.CommentPatchDto;
import com.moovda_project.moovda.module.comment.dto.CommentPostDto;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import org.mapstruct.Mapper;

import java.util.HashSet;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    default Comment commentPostDtoToComment(CommentPostDto commentPostDto,long movieId, long memberId) {

        Comment comment = Comment.builder().
                content(commentPostDto.getContent()).
                star(commentPostDto.getStar()).
                movie(new Movie(movieId)).
                member(new Member(memberId)).
                likes(new HashSet<>()).
                build();

        return comment;
    }
   default Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto) {
       Comment comment = Comment.builder()
               .commentId(commentPatchDto.getCommentId())
               .content(commentPatchDto.getContent())
               .star(commentPatchDto.getStar())
               .build();

       return comment;
   }
}
