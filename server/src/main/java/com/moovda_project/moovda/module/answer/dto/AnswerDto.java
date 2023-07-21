package com.moovda_project.moovda.module.answer.dto;

import lombok.*;

import javax.validation.constraints.Size;
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
        @Size(min = 10, message = "답변 내용은 10자 이상이어야합니다.")
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
        @Size(min = 10, message = "답변 내용은 10자 이상이어야합니다.")
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

        private AnswerMovie movie;

        private long memberId;

        private LocalDateTime createdAt;
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AnswerMovie {
        private String title;
        private String poster;
    }
}
