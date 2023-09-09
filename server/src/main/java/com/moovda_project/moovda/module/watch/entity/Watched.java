package com.moovda_project.moovda.module.watch.entity;

import com.moovda_project.moovda.global.audit.Auditable;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "watched")
public class Watched extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watched_id")
    private Long watchedId;

    @Column(name = "star")
    private double star;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Watched(double star, Movie movie, Member member) {
        this.star = star;
        this.movie = movie;
        this.member = member;
    }

    public void setMember(Member member) {
        this.member = member;
        if(!this.member.getWatchedList().contains(this)) {
            this.member.addWatchedList(this);
        }
    }

    public void setStar(double star) {
        this.star = star;
    }
}
