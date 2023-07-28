package com.moovda_project.moovda.module.question.entity;

import com.moovda_project.moovda.module.answer.entity.Answer;
import com.moovda_project.moovda.global.audit.Auditable;
import com.moovda_project.moovda.module.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private int views;

    private int answerCount;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answers = new ArrayList<>();

    public void addView(int view) {
        this.views = view + 1;
    }

    public void addAnswerCount(int answerCount) {
        this.answerCount = answerCount + 1;
    }

    public void minusAnswerCount(int answerCount) {
        this.answerCount = answerCount - 1;
    }

}
