package com.moovda_project.moovda.question.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class QuestionDto {
    public static class Post {
        @Positive
        private long memberId;

        @Size(min = 5, max = 30)
        @NotBlank
        private String title;

        @Size(min = 10)
        @NotBlank
        private String content;

        public Member getMember() {
            Member member = new Member();
            member.setMemberId(memberId);
            return member;
        }
    }

    public static class Patch {

        private long questionId;

        private String title;

        private String content;

        public void addQuestionId(long questionId) {
            this.questionId = questionId;
        }
    }
}
