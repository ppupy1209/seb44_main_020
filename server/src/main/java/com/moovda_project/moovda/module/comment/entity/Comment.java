package com.moovda_project.moovda.module.comment.entity;

import com.moovda_project.moovda.global.audit.Auditable;
import com.moovda_project.moovda.module.like.entity.Like;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor()
@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "star", nullable = false)
    private double star;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "comment",cascade = CascadeType.REMOVE)
    Set<Like> likes = new HashSet<>();

    public void addLikes(Like like) {
        this.likes.add(like);
        like.setComment(this);
    }

    public void removeLikes(Like like) {
        this.likes.remove(like);
    }
}
