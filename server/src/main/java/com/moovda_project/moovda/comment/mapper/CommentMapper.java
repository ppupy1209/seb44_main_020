package com.moovda_project.moovda.comment.mapper;

import com.moovda_project.moovda.comment.dto.CommentPatchDto;
import com.moovda_project.moovda.comment.dto.CommentPostDto;
import com.moovda_project.moovda.comment.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    Comment commentPostDtoToComment(CommentPostDto commentPostDto);
    Comment commentPatchDtoToComment(CommentPatchDto commentPatchDto);
}
