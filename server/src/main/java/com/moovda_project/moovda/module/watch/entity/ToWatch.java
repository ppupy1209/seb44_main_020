package com.moovda_project.moovda.module.watch.entity;

import com.moovda_project.moovda.global.audit.Auditable;
import com.moovda_project.moovda.module.member.entity.Member;
import com.moovda_project.moovda.module.movie.entity.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "to_watch")
public class ToWatch extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "to_watch_id")
    private Long toWatchId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public ToWatch(Movie movie, Member member) {
        this.movie = movie;
        this.member = member;
    }

    public void setMember(Member member) {
        this.member = member;
        if(!this.member.getToWatchList().contains(this)) {
            this.member.addToWatchList(this);
        }
    }
}
