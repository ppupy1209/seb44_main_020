package com.moovda_project.moovda.answer.entity;

import com.moovda_project.moovda.audit.Auditable;
import com.moovda_project.moovda.member.entity.Member;
import com.moovda_project.moovda.movie.entity.Movie;
import com.moovda_project.moovda.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
