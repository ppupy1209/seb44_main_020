package com.moovda_project.moovda.module.comment.entity;

import com.moovda_project.moovda.global.audit.Auditable;
import com.moovda_project.moovda.module.like.entity.Like;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "comments")
public class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id",nullable = false,updatable = false)
    private Long commentId;

    @Setter
    @Column(name = "content", nullable = false)
    private String content;
    @Setter
    @Column(name = "star", nullable = false)
    private Double star;
    @Setter
    @Transient
    private boolean likeState;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "comment",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Set<Like> likes = new HashSet<>();

    @Builder
    public Comment(String content, double star, Movie movie, Member member) {
        this.content = content;
        this.star = star;
        this.movie = movie;
        this.member = member;
        this.likes = new HashSet<>();
    }
    public Comment(Long commentId, String content, Double star) {
        this.commentId = commentId;
        this.content = content;
        this.star = star;
    }
}
