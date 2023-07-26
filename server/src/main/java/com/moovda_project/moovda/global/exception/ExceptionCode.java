package com.moovda_project.moovda.global.exception;

import lombok.Getter;

public enum ExceptionCode {

    // 401
    MEMBER_UNAUTHORIZED(401,"Member unauthorized"),



    // 403
    QUESTION_EXIST_ANSWER(403, "Question has answer"),

    // 404
    ANSWER_NOT_FOUND(404, "Answer not found"),
    COMMENT_NOT_FOUND(404, "Comment not found"),
    MEMBER_NOT_FOUND(404, "Member not found"),
    QUESTION_NOT_FOUND(404, "Question not found"),
    MOVIE_NOT_FOUND(404,"Movie not found"),
    WATCHED_NOT_FOUND(404,"Watched not found"),

    TOWATCH_NOT_FOUND(404,"ToWatch not found"),


    // 409
    MEMBER_EXISTS(409, "Member exists"),
    COMMENT_EXISTS(409,"Comment exists"),

    WATCHED_EXISTS(409,"Watched exists"),

    TOWATCH_EXISTS(409,"ToWatch exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
