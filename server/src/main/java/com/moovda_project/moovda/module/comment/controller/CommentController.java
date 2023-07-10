package com.moovda_project.moovda.module.comment.controller;

import com.moovda_project.moovda.module.comment.dto.CommentPatchDto;
import com.moovda_project.moovda.module.comment.dto.CommentPostDto;
import com.moovda_project.moovda.module.comment.entity.Comment;
import com.moovda_project.moovda.module.comment.mapper.CommentMapper;
import com.moovda_project.moovda.module.comment.service.CommentService;
import com.moovda_project.moovda.global.auth.utils.MemberIdExtractor;
import com.moovda_project.moovda.global.utils.UriCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/comments")
@Validated
public class CommentController {
    private final static String COMMENT_DEFAULT_URL = "/comments";
    private final CommentService commentService;
    private final CommentMapper mapper;

    public CommentController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @PostMapping("/{movie_id}")
    public ResponseEntity postComment(@PathVariable("movie_id") @Positive long movieId,
                                      @Valid @RequestBody CommentPostDto commentPostDto) {
        long memberId = MemberIdExtractor.extractMemberId();

        Comment comment = commentService.createComment(mapper.commentPostDtoToComment(commentPostDto),movieId,memberId);

        URI location = UriCreator.createUri(COMMENT_DEFAULT_URL,comment.getCommentId());

        return ResponseEntity.created(location).build();
    }


    @PatchMapping("/{comment_id}/{movie_id}")
    public ResponseEntity patchComment(@PathVariable("comment_id") @Positive long commentId,
                                       @PathVariable("movie_id") @Positive long movieId,
                                       @Valid @RequestBody CommentPatchDto commentPatchDto) {
        long memberId = MemberIdExtractor.extractMemberId();
        commentPatchDto.setCommentId(commentId);

        Comment comment = commentService.updateComment(mapper.commentPatchDtoToComment(commentPatchDto),memberId,movieId);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{comment_id}")
    public ResponseEntity deleteComment(@PathVariable("comment_id") @Positive long commentId) {
        long memberId = MemberIdExtractor.extractMemberId();

        commentService.deleteComment(commentId,memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
