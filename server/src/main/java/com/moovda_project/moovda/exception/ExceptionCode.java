package com.moovda_project.moovda.exception;

import lombok.Getter;

public enum ExceptionCode {
    // 403
    QUESTION_EXIST_ANSWER(403, "Question has answer"),

    // 404
    ANSWER_NOT_FOUND(404, "Answer not found"),
    COMMENT_NOT_FOUND(404, "Comment not found"),
    MEMBER_NOT_FOUND(404, "Member not found"),
    QUESTION_NOT_FOUND(404, "Question not found"),
    MOVIE_NOT_FOUND(404,"Movie not found"),
    WATCHED_NOT_FOUND(404,"Watched not found"),


    // 409
    MEMBER_EXISTS(409, "Member exists");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
