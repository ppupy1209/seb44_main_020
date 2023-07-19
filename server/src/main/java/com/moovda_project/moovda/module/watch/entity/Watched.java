package com.moovda_project.moovda.module.watch.entity;

import com.moovda_project.moovda.global.audit.Auditable;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Watched(Movie movie, Member member) {
        this.movie = movie;
        this.member = member;
    }

    public void setMember(Member member) {
        this.member = member;
        if(!this.member.getWatchedList().contains(this)) {
            this.member.addWatchedList(this);
        }
    }
}
