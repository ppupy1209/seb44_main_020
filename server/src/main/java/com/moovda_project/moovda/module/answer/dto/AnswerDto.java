package com.moovda_project.moovda.module.answer.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
public class AnswerDto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {
        private long memberId;
        private long questionId;
        private String content;
        private String title;
        private String poster;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch {
        private long answerId;
        private long authenticatedMemberId;
        private long questionId;
        private String content;
        private String title;
        private String poster;

        public void addAnswerId(long answerId) {
            this.answerId = answerId;
        }

        public void addQuestionId(long questionId) {this.questionId = questionId;}

        public void addAuthenticatedMemberId(long authenticatedMemberId) {
            this.authenticatedMemberId = authenticatedMemberId;
        }
    }

    @Getter @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PatchResponse {
        private String content;
//        private MovieQuestionResponseDto movie;
        private LocalDateTime modifiedAt;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private long answerId;

        private long questionId;

        private String nickname;

        private String content;

        private String title;

        private String poster;

        private long memberId;

        private LocalDateTime createdAt;
    }
}
